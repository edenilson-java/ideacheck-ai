const Validator = (() => {
  const RULES = {
    titulo: {
      required: true,
      minLength: 5,
      maxLength: 120,
      messages: {
        required: 'O título é obrigatório.',
        minLength: 'O título deve ter pelo menos 5 caracteres.',
        maxLength: 'O título deve ter no máximo 120 caracteres.',
      },
    },
    segmento: {
      required: true,
      messages: {
        required: 'Selecione um segmento para a sua ideia.',
      },
    },
    descricao: {
      required: true,
      minLength: 20,
      maxLength: 1000,
      messages: {
        required: 'A descrição é obrigatória.',
        minLength: 'Descreva melhor sua ideia — mínimo de 20 caracteres.',
        maxLength: 'A descrição deve ter no máximo 1000 caracteres.',
      },
    },
    publicoAlvo: {
      required: false,
      maxLength: 200,
      messages: {
        maxLength: 'O público-alvo deve ter no máximo 200 caracteres.',
      },
    },
    problema: {
      required: false,
      maxLength: 500,
      messages: {
        maxLength: 'A descrição do problema deve ter no máximo 500 caracteres.',
      },
    },
  };

  function validateField(name, value) {
    const rule = RULES[name];
    if (!rule) return null;

    const trimmed = typeof value === 'string' ? value.trim() : value || '';

    if (rule.required && !trimmed) {
      return rule.messages.required;
    }

    if (trimmed && rule.minLength && trimmed.length < rule.minLength) {
      return rule.messages.minLength;
    }

    if (trimmed && rule.maxLength && trimmed.length > rule.maxLength) {
      return rule.messages.maxLength;
    }

    return null;
  }

  function validateStep(step, formData) {
    const errors = {};

    if (step === 1) {
      const tituloError = validateField('titulo', formData.titulo);
      if (tituloError) errors.titulo = tituloError;

      const segmentoError = validateField('segmento', formData.segmento);
      if (segmentoError) errors.segmento = segmentoError;
    }

    if (step === 2) {
      const descricaoError = validateField('descricao', formData.descricao);
      if (descricaoError) errors.descricao = descricaoError;

      const publicoAlvoError = validateField('publicoAlvo', formData.publicoAlvo);
      if (publicoAlvoError) errors.publicoAlvo = publicoAlvoError;

      const problemaError = validateField('problema', formData.problema);
      if (problemaError) errors.problema = problemaError;
    }

    return errors;
  }

  function isStepValid(step, formData) {
    return Object.keys(validateStep(step, formData)).length === 0;
  }

  return { validateField, validateStep, isStepValid };
})();
