const App = (() => {
  const TOTAL_STEPS = 3;

  const state = {
    currentStep: 1,
    isSubmitting: false,
    formData: {
      titulo: '',
      segmento: '',
      descricao: '',
      publicoAlvo: '',
      problema: '',
    },
  };

  function _getFormData() {
    return {
      titulo: document.getElementById('titulo')?.value.trim() || '',
      segmento: document.getElementById('segmento')?.value || '',
      descricao: document.getElementById('descricao')?.value.trim() || '',
      publicoAlvo: document.getElementById('publicoAlvo')?.value.trim() || '',
      problema: document.getElementById('problema')?.value.trim() || '',
    };
  }

  function _updateState() {
    state.formData = _getFormData();
    Storage.save(state.formData);
  }

  function _showStepErrors(errors) {
    UI.clearAllErrors();
    Object.entries(errors).forEach(([field, msg]) => UI.setFieldError(field, msg));
    const firstErrorField = Object.keys(errors)[0];
    if (firstErrorField) {
      const el = document.getElementById(firstErrorField);
      if (el) el.focus();
    }
  }

  function _goToStep(step) {
    state.currentStep = step;
    UI.updateProgress(step, TOTAL_STEPS);
    UI.showStep(step);
    UI.clearAllErrors();

    if (step === TOTAL_STEPS) {
      _updateState();
      const reviewCard = document.getElementById('review-card');
      if (reviewCard) UI.renderReviewCard(reviewCard, state.formData);
    }

    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  function _nextStep(fromStep) {
    _updateState();
    const errors = Validator.validateStep(fromStep, state.formData);

    if (Object.keys(errors).length > 0) {
      _showStepErrors(errors);
      UI.showToast('Verifique os campos destacados.', 'error');
      return;
    }

    _goToStep(fromStep + 1);
  }

  function _prevStep(fromStep) {
    _goToStep(fromStep - 1);
  }

  async function _handleSubmit(e) {
    e.preventDefault();

    if (state.isSubmitting) return;

    _updateState();

    const step1Errors = Validator.validateStep(1, state.formData);
    const step2Errors = Validator.validateStep(2, state.formData);
    const allErrors = { ...step1Errors, ...step2Errors };

    if (Object.keys(allErrors).length > 0) {
      UI.showToast('Há campos inválidos. Volte e verifique.', 'error');
      return;
    }

    state.isSubmitting = true;

    const submitBtn = document.getElementById('submit-btn');
    if (submitBtn) {
      submitBtn.disabled = true;
      submitBtn.innerHTML = `
        <svg class="spin" width="16" height="16" viewBox="0 0 24 24" fill="none">
          <circle cx="12" cy="12" r="10" stroke="currentColor" stroke-width="3" stroke-dasharray="62.83" stroke-dashoffset="40"/>
        </svg>
        Analisando...
      `;
    }

    UI.showSection('loading-section');

    const loadingStepsContainer = document.getElementById('loading-steps');
    let cancelLoadingAnimation = () => {};
    if (loadingStepsContainer) {
      cancelLoadingAnimation = UI.renderLoadingSteps(loadingStepsContainer);
    }

    try {
      const result = await ApiService.validateIdea(state.formData);

      cancelLoadingAnimation();

      const resultsHeader = document.getElementById('results-header');
      const resultsGrid = document.getElementById('results-grid');

      UI.renderResults(resultsGrid, resultsHeader, result, state.formData.titulo);
      UI.showSection('results-section');
      Storage.clear();
    } catch (err) {
      cancelLoadingAnimation();
      UI.showSection('form-section');
      _goToStep(TOTAL_STEPS);

      const message =
        err?.message || 'Ocorreu um erro ao analisar sua ideia. Tente novamente.';
      UI.showToast(message, 'error', 6000);
    } finally {
      state.isSubmitting = false;
      if (submitBtn) {
        submitBtn.disabled = false;
        submitBtn.innerHTML = `
          <svg width="16" height="16" viewBox="0 0 24 24" fill="none">
            <path d="M13 10V3L4 14h7v7l9-11h-7z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
          </svg>
          Analisar ideia
        `;
      }
    }
  }

  function _resetApp() {
    state.currentStep = 1;
    state.isSubmitting = false;
    state.formData = { titulo: '', segmento: '', descricao: '', publicoAlvo: '', problema: '' };

    const form = document.getElementById('idea-form');
    if (form) form.reset();

    const hiddenSegmento = document.getElementById('segmento');
    if (hiddenSegmento) hiddenSegmento.value = '';

    const segmentContainer = document.getElementById('segment-selector');
    if (segmentContainer) {
      UI.renderSegments(segmentContainer, '', (val) => {
        document.getElementById('segmento').value = val;
        state.formData.segmento = val;
        UI.setFieldError('segmento', null);
        Storage.save(state.formData);
      });
    }

    UI.clearAllErrors();
    UI.showSection('form-section');
    _goToStep(1);
    Storage.clear();
  }

  function _restoreDraft() {
    const draft = Storage.load();
    if (!draft) return;

    const fields = ['titulo', 'descricao', 'publicoAlvo', 'problema'];
    fields.forEach((field) => {
      const el = document.getElementById(field);
      if (el && draft[field]) {
        el.value = draft[field];
        const counterId = `${field}-counter`;
        const maxAttr = el.getAttribute('maxlength');
        if (maxAttr) UI.updateCounter(el, counterId, parseInt(maxAttr, 10));
      }
    });

    if (draft.segmento) {
      const hiddenSegmento = document.getElementById('segmento');
      if (hiddenSegmento) hiddenSegmento.value = draft.segmento;

      const segmentContainer = document.getElementById('segment-selector');
      if (segmentContainer) {
        segmentContainer.querySelectorAll('.segment-card').forEach((btn) => {
          const isSelected = btn.dataset.value === draft.segmento;
          btn.classList.toggle('selected', isSelected);
          btn.setAttribute('aria-pressed', String(isSelected));
        });
      }
    }

    if (Object.values(draft).some(Boolean)) {
      UI.showToast('Rascunho restaurado automaticamente.', 'info', 3000);
    }
  }

  function _setupCounters() {
    const counters = [
      { id: 'titulo', counterId: 'titulo-counter', max: 120 },
      { id: 'descricao', counterId: 'descricao-counter', max: 1000 },
      { id: 'problema', counterId: 'problema-counter', max: 500 },
    ];

    counters.forEach(({ id, counterId, max }) => {
      const el = document.getElementById(id);
      if (!el) return;
      el.addEventListener('input', () => {
        UI.updateCounter(el, counterId, max);
        _updateState();
      });
    });

    const publicoAlvoEl = document.getElementById('publicoAlvo');
    if (publicoAlvoEl) {
      publicoAlvoEl.addEventListener('input', _updateState);
    }
  }

  function _setupInlineValidation() {
    const fields = ['titulo', 'descricao', 'publicoAlvo', 'problema'];
    fields.forEach((fieldId) => {
      const el = document.getElementById(fieldId);
      if (!el) return;
      el.addEventListener('blur', () => {
        const error = Validator.validateField(fieldId, el.value);
        UI.setFieldError(fieldId, error);
      });
      el.addEventListener('input', () => {
        if (el.classList.contains('input--error')) {
          const error = Validator.validateField(fieldId, el.value);
          UI.setFieldError(fieldId, error);
        }
      });
    });
  }

  function _setupTheme() {
    const theme = Storage.loadTheme();
    document.documentElement.setAttribute('data-theme', theme);

    const toggleBtn = document.getElementById('theme-toggle');
    if (!toggleBtn) return;

    function updateIcon(t) {
      toggleBtn.innerHTML =
        t === 'dark'
          ? `<svg width="18" height="18" viewBox="0 0 24 24" fill="none"><path d="M21 12.79A9 9 0 1111.21 3 7 7 0 0021 12.79z" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/></svg>`
          : `<svg width="18" height="18" viewBox="0 0 24 24" fill="none"><circle cx="12" cy="12" r="5" stroke="currentColor" stroke-width="2"/><path d="M12 1v2M12 21v2M4.22 4.22l1.42 1.42M18.36 18.36l1.42 1.42M1 12h2M21 12h2M4.22 19.78l1.42-1.42M18.36 5.64l1.42-1.42" stroke="currentColor" stroke-width="2" stroke-linecap="round"/></svg>`;
    }

    updateIcon(theme);

    toggleBtn.addEventListener('click', () => {
      const current = document.documentElement.getAttribute('data-theme') || 'light';
      const next = current === 'light' ? 'dark' : 'light';
      document.documentElement.setAttribute('data-theme', next);
      Storage.saveTheme(next);
      updateIcon(next);
    });
  }

  function init() {
    _setupTheme();

    const segmentContainer = document.getElementById('segment-selector');
    if (segmentContainer) {
      UI.renderSegments(segmentContainer, '', (val) => {
        document.getElementById('segmento').value = val;
        state.formData.segmento = val;
        UI.setFieldError('segmento', null);
        Storage.save(state.formData);
      });
    }

    _setupCounters();
    _setupInlineValidation();

    document.getElementById('next-step-1')?.addEventListener('click', () => _nextStep(1));
    document.getElementById('prev-step-2')?.addEventListener('click', () => _prevStep(2));
    document.getElementById('next-step-2')?.addEventListener('click', () => _nextStep(2));
    document.getElementById('prev-step-3')?.addEventListener('click', () => _prevStep(3));
    document.getElementById('idea-form')?.addEventListener('submit', _handleSubmit);
    document.getElementById('new-analysis-btn')?.addEventListener('click', _resetApp);

    UI.showStep(1);
    UI.updateProgress(1, TOTAL_STEPS);
    UI.showSection('form-section');

    setTimeout(_restoreDraft, 300);
  }

  return { init };
})();

document.addEventListener('DOMContentLoaded', App.init);
