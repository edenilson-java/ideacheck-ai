const UI = (() => {
  const SEGMENTS = [
    { value: 'Saúde', icon: '🏥', label: 'Saúde' },
    { value: 'Educação', icon: '📚', label: 'Educação' },
    { value: 'Tecnologia', icon: '💻', label: 'Tecnologia' },
    { value: 'Comércio', icon: '🛒', label: 'Comércio' },
    { value: 'Serviços', icon: '🔧', label: 'Serviços' },
    { value: 'Finanças', icon: '💰', label: 'Finanças' },
    { value: 'Sustentabilidade', icon: '🌱', label: 'Sustentabilidade' },
    { value: 'Entretenimento', icon: '🎨', label: 'Entretenimento' },
  ];

  const LOADING_STEPS = [
    'Identificando o problema central...',
    'Mapeando público-alvo provável...',
    'Avaliando proposta de valor...',
    'Analisando concorrentes e alternativas...',
    'Identificando riscos e pontos fortes...',
    'Calculando nota de viabilidade...',
    'Preparando análise estruturada...',
  ];

  let toastTimer = null;

  function renderSegments(container, selectedValue, onSelect) {
    container.innerHTML = SEGMENTS.map(
      (s) => `
      <button
        type="button"
        class="segment-card${selectedValue === s.value ? ' selected' : ''}"
        data-value="${s.value}"
        aria-pressed="${selectedValue === s.value}"
        title="${s.value}"
      >
        <span class="segment-card__icon">${s.icon}</span>
        <span class="segment-card__label">${s.label}</span>
      </button>
    `
    ).join('');

    container.querySelectorAll('.segment-card').forEach((btn) => {
      btn.addEventListener('click', () => {
        const val = btn.dataset.value;
        container.querySelectorAll('.segment-card').forEach((b) => {
          b.classList.remove('selected');
          b.setAttribute('aria-pressed', 'false');
        });
        btn.classList.add('selected');
        btn.setAttribute('aria-pressed', 'true');
        onSelect(val);
      });
    });
  }

  function renderReviewCard(container, formData) {
    const fields = [
      { label: 'Título', value: formData.titulo, required: true },
      { label: 'Segmento', value: formData.segmento, required: true },
      { label: 'Descrição', value: formData.descricao, required: true },
      { label: 'Público-alvo', value: formData.publicoAlvo, required: false },
      { label: 'Problema', value: formData.problema, required: false },
    ];

    container.innerHTML = fields
      .map((f) => {
        if (!f.required && !f.value) return '';
        return `
        <div class="review-field">
          <span class="review-field__label">${f.label}${f.required ? '' : ' <span class="badge badge--optional">opcional</span>'}</span>
          <p class="review-field__value">${f.value || '<em class="text-muted">Não informado</em>'}</p>
        </div>
      `;
      })
      .join('');
  }

  function renderLoadingSteps(container) {
    container.innerHTML = LOADING_STEPS.map(
      (step, i) => `
      <div class="loading-step" id="loading-step-${i}" aria-live="polite">
        <span class="loading-step__icon">
          <svg width="16" height="16" viewBox="0 0 16 16" fill="none">
            <circle cx="8" cy="8" r="7" stroke="currentColor" stroke-width="1.5" opacity="0.3"/>
          </svg>
        </span>
        <span class="loading-step__text">${step}</span>
      </div>
    `
    ).join('');

    let idx = 0;
    const interval = setInterval(() => {
      const stepEl = document.getElementById(`loading-step-${idx}`);
      if (stepEl) {
        stepEl.classList.add('active');
        stepEl.querySelector('svg circle').setAttribute('opacity', '1');
        stepEl.querySelector('svg').innerHTML = `
          <path d="M3 8l3.5 3.5L13 4" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
        `;
      }
      idx++;
      if (idx >= LOADING_STEPS.length) clearInterval(interval);
    }, 420);

    return () => clearInterval(interval);
  }

  function _scoreColor(score) {
    if (score >= 7) return '#059669';
    if (score >= 5) return '#D97706';
    return '#DC2626';
  }

  function _scoreLabel(score) {
    if (score >= 8) return 'Excelente';
    if (score >= 7) return 'Boa';
    if (score >= 5) return 'Moderada';
    return 'Baixa';
  }

  function _scoreClass(score) {
    if (score >= 7) return 'high';
    if (score >= 5) return 'mid';
    return 'low';
  }

  function renderScoreCircle(score) {
    const radius = 52;
    const circumference = 2 * Math.PI * radius;
    const offset = circumference - (score / 10) * circumference;
    const color = _scoreColor(score);
    const label = _scoreLabel(score);

    return `
      <div class="score-display">
        <div class="score-circle-wrap score-circle-wrap--${_scoreClass(score)}">
          <svg class="score-svg" viewBox="0 0 120 120" fill="none" aria-label="Nota ${score} de 10">
            <circle cx="60" cy="60" r="${radius}" stroke="currentColor" stroke-width="8" class="score-track"/>
            <circle
              cx="60" cy="60" r="${radius}"
              stroke="${color}"
              stroke-width="8"
              stroke-linecap="round"
              stroke-dasharray="${circumference}"
              stroke-dashoffset="${circumference}"
              transform="rotate(-90 60 60)"
              class="score-arc"
              style="--target-offset: ${offset}"
            />
          </svg>
          <div class="score-inner">
            <span class="score-number">${score}</span>
            <span class="score-max">/10</span>
          </div>
        </div>
        <p class="score-label score-label--${_scoreClass(score)}">${label}</p>
        <p class="score-sub">Viabilidade estimada</p>
      </div>
    `;
  }

  function _tagList(items, variant = 'default') {
    if (!items || items.length === 0) return '<p class="text-muted">Não identificado.</p>';
    return `<ul class="tag-list">${items.map((item) => `<li class="tag tag--${variant}">${item}</li>`).join('')}</ul>`;
  }

  function _stepList(items) {
    if (!items || items.length === 0) return '<p class="text-muted">Não identificado.</p>';
    return `<ol class="step-list">${items.map((item, i) => `<li class="step-list__item"><span class="step-list__num">${i + 1}</span><span>${item}</span></li>`).join('')}</ol>`;
  }

  function renderResults(container, headerEl, data, titulo) {
    headerEl.innerHTML = `
      <div class="results-hero">
        <div class="results-hero__left">
          <span class="badge badge--ai">✦ Análise gerada por IA</span>
          <h1 class="results-title">${titulo}</h1>
          <p class="results-subtitle">${data.resumo}</p>
        </div>
        <div class="results-hero__right">
          ${renderScoreCircle(data.notaViabilidade)}
        </div>
      </div>
    `;

    container.className = 'results-grid';
    container.innerHTML = `

        <div class="result-card result-card--full">
          <div class="result-card__header">
            <span class="result-card__icon">💡</span>
            <h3>Problema identificado</h3>
          </div>
          <p class="result-text">${data.problema}</p>
        </div>

        <div class="result-card">
          <div class="result-card__header">
            <span class="result-card__icon">🎯</span>
            <h3>Público-alvo</h3>
          </div>
          <p class="result-text">${data.publicoAlvo}</p>
        </div>

        <div class="result-card">
          <div class="result-card__header">
            <span class="result-card__icon">🚀</span>
            <h3>Proposta de valor</h3>
          </div>
          <p class="result-text">${data.propostaValor}</p>
        </div>

        <div class="result-card">
          <div class="result-card__header">
            <span class="result-card__icon">✅</span>
            <h3>Pontos fortes</h3>
          </div>
          ${_tagList(data.pontosFortes, 'success')}
        </div>

        <div class="result-card">
          <div class="result-card__header">
            <span class="result-card__icon">⚠️</span>
            <h3>Riscos e atenções</h3>
          </div>
          ${_tagList(data.riscos, 'warning')}
        </div>

        <div class="result-card result-card--full">
          <div class="result-card__header">
            <span class="result-card__icon">🏢</span>
            <h3>Concorrentes e alternativas</h3>
          </div>
          ${_tagList(data.concorrenciaAlternativas, 'neutral')}
        </div>

        <div class="result-card result-card--full">
          <div class="result-card__header">
            <span class="result-card__icon">🔍</span>
            <h3>Análise do segmento</h3>
          </div>
          <p class="result-text">${data.analiseDoSegmento}</p>
        </div>

        <div class="result-card">
          <div class="result-card__header">
            <span class="result-card__icon">❓</span>
            <h3>Perguntas em aberto</h3>
          </div>
          ${_tagList(data.perguntasAbertas, 'neutral')}
        </div>

        <div class="result-card result-card--score-detail">
          <div class="result-card__header">
            <span class="result-card__icon">📊</span>
            <h3>Nota ${data.notaViabilidade}/10 — Justificativa</h3>
          </div>
          <p class="result-text">${data.justificativaNota}</p>
        </div>

        <div class="result-card result-card--full result-card--highlighted">
          <div class="result-card__header">
            <span class="result-card__icon">🗺️</span>
            <h3>Próximos passos</h3>
          </div>
          ${_stepList(data.proximosPassos)}
        </div>
    `;

    requestAnimationFrame(() => {
      document.querySelectorAll('.score-arc').forEach((arc) => {
        arc.style.animation = 'none';
        arc.getBoundingClientRect();
        arc.style.animation = '';
      });
    });
  }

  function showToast(message, type = 'info', duration = 4000) {
    const container = document.getElementById('toast-container');
    if (!container) return;

    const icons = {
      success: '✓',
      error: '✕',
      info: 'ℹ',
      warning: '⚠',
    };

    const toast = document.createElement('div');
    toast.className = `toast toast--${type}`;
    toast.setAttribute('role', 'alert');
    toast.innerHTML = `
      <span class="toast__icon">${icons[type] || icons.info}</span>
      <span class="toast__message">${message}</span>
      <button class="toast__close" aria-label="Fechar notificação">✕</button>
    `;

    container.appendChild(toast);

    toast.querySelector('.toast__close').addEventListener('click', () => dismissToast(toast));

    requestAnimationFrame(() => toast.classList.add('toast--visible'));

    if (toastTimer) clearTimeout(toastTimer);
    toastTimer = setTimeout(() => dismissToast(toast), duration);
  }

  function dismissToast(toast) {
    toast.classList.remove('toast--visible');
    toast.addEventListener('transitionend', () => toast.remove(), { once: true });
  }

  function setFieldError(fieldId, message) {
    const input = document.getElementById(fieldId);
    const error = document.getElementById(`${fieldId}-error`);
    if (input) input.classList.toggle('input--error', !!message);
    if (error) {
      error.textContent = message || '';
      error.classList.toggle('visible', !!message);
    }
  }

  function clearAllErrors() {
    document.querySelectorAll('.field-error').forEach((el) => {
      el.textContent = '';
      el.classList.remove('visible');
    });
    document.querySelectorAll('.input--error, .textarea--error').forEach((el) => {
      el.classList.remove('input--error', 'textarea--error');
    });
  }

  function updateCounter(inputEl, counterId, max) {
    const counter = document.getElementById(counterId);
    if (!counter) return;
    const len = inputEl.value.length;
    counter.textContent = `${len}/${max}`;
    counter.classList.toggle('counter--warn', len > max * 0.85);
    counter.classList.toggle('counter--over', len >= max);
  }

  function updateProgress(step, total) {
    const fill = document.getElementById('progress-fill');
    if (fill) fill.style.width = `${((step - 1) / (total - 1)) * 100}%`;

    document.querySelectorAll('.step-indicator').forEach((el) => {
      const s = parseInt(el.dataset.step, 10);
      el.classList.remove('active', 'completed');
      if (s === step) el.classList.add('active');
      if (s < step) el.classList.add('completed');
    });
  }

  function showSection(id) {
    ['form-section', 'loading-section', 'results-section'].forEach((sId) => {
      const el = document.getElementById(sId);
      if (el) el.classList.toggle('hidden', sId !== id);
    });
    window.scrollTo({ top: 0, behavior: 'smooth' });
  }

  function showStep(step) {
    document.querySelectorAll('.form-step').forEach((el) => {
      const s = parseInt(el.dataset.step, 10);
      el.classList.remove('form-step--active', 'form-step--exit-left', 'form-step--exit-right');
      el.classList.toggle('form-step--active', s === step);
    });
  }

  return {
    renderSegments,
    renderReviewCard,
    renderLoadingSteps,
    renderResults,
    showToast,
    setFieldError,
    clearAllErrors,
    updateCounter,
    updateProgress,
    showSection,
    showStep,
  };
})();
