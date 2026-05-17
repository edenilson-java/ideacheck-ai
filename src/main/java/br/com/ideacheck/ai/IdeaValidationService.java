package br.com.ideacheck.ai;

import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Serviço de validação de ideias.
 * Orquestra a chamada ao AiClient e retorna a análise estruturada.
 */
@Service
public class IdeaValidationService {

    private static final Logger log = LoggerFactory.getLogger(IdeaValidationService.class);

    private final AiClient aiClient;

    public IdeaValidationService(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    public ValidationResponse validate(ValidationRequest request) {
        log.info("Iniciando validação da ideia: {}", request.titulo());
        ValidationResponse response = aiClient.analyze(request);
        log.info("Validação concluída para: {} | Nota: {}", request.titulo(), response.notaViabilidade());
        return response;
    }
}
