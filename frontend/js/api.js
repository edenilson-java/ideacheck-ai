const ApiService = (() => {
  const { BASE_URL, USE_MOCK, MOCK_DELAY_MS } = window.APP_CONFIG || {
    BASE_URL: 'http://localhost:8080/api/v1',
    USE_MOCK: true,
    MOCK_DELAY_MS: 3200,
  };

  function _mockValidate(formData) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (Math.random() < 0.05) {
          reject({
            status: 500,
            message: 'Serviço de IA temporariamente indisponível. Tente novamente.',
          });
          return;
        }
        resolve(generateMockResponse(formData));
      }, MOCK_DELAY_MS);
    });
  }

  function _isNetworkError(err) {
    return err instanceof TypeError && err.message === 'Failed to fetch';
  }

  async function _realValidate(formData) {
    let response;
    try {
      response = await fetch(`${BASE_URL}/validate-idea`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(formData),
      });
    } catch (err) {
      if (_isNetworkError(err)) {
        throw {
          status: 0,
          message: 'Não foi possível conectar ao servidor.',
        };
      }
      throw { status: 0, message: 'Erro de rede inesperado. Tente novamente.' };
    }

    if (!response.ok) {
      const errorData = await response.json().catch(() => ({}));
      throw {
        status: response.status,
        message:
          errorData.message || `Erro ${response.status}: ${response.statusText}`,
        details: errorData.details || [],
      };
    }

    return response.json();
  }

  async function validateIdea(formData) {
    if (USE_MOCK) {
      return _mockValidate(formData);
    }
    return _realValidate(formData);
  }

  async function checkHealth() {
    if (USE_MOCK) {
      return { status: 'UP', application: 'IdeaCheck AI' };
    }
    try {
      const response = await fetch(`${BASE_URL}/health`);
      return response.json();
    } catch (err) {
      if (_isNetworkError(err)) {
        return { status: 'DOWN', message: 'Backend indisponível.' };
      }
      return { status: 'UNKNOWN' };
    }
  }

  return { validateIdea, checkHealth };
})();
