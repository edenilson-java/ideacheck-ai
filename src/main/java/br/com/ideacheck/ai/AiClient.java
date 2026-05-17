package br.com.ideacheck.ai;

import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;

/**
 * Contrato para clientes de IA.
 * Permite alternar entre implementação real (LLM) e mock sem alterar o service.
 */
public interface AiClient {

    ValidationResponse analyze(ValidationRequest request);
}
