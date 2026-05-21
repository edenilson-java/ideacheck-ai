package br.com.ideacheck.service;

import br.com.ideacheck.dto.ValidationRequest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Component
public class PromptBuilder {

    private static final String PROMPT_TEMPLATE_PATH = "prompts/business-validator-system.txt";

    private static final String TITULO_PLACEHOLDER = "{{titulo}}";
    private static final String DESCRICAO_PLACEHOLDER = "{{descricao}}";
    private static final String SEGMENTO_PLACEHOLDER = "{{segmento}}";
    private static final String PUBLICO_ALVO_PLACEHOLDER = "{{publicoAlvo}}";
    private static final String PROBLEMA_PLACEHOLDER = "{{problema}}";

    private final String promptTemplate;

    public PromptBuilder() {
        this.promptTemplate = loadPromptTemplate();
    }

    public String buildPrompt(ValidationRequest request) {
        if (request == null) {
            throw new PromptBuilderException("ValidationRequest não pode ser nulo.");
        }

        Map<String, String> replacements = Map.of(
                TITULO_PLACEHOLDER, sanitizeForJsonString(request.titulo()),
                DESCRICAO_PLACEHOLDER, sanitizeForJsonString(request.descricao()),
                SEGMENTO_PLACEHOLDER, sanitizeForJsonString(request.segmento()),
                PUBLICO_ALVO_PLACEHOLDER, sanitizeForJsonString(request.publicoAlvo()),
                PROBLEMA_PLACEHOLDER, sanitizeForJsonString(request.problema())
        );

        String prompt = promptTemplate;

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            prompt = prompt.replace(entry.getKey(), entry.getValue());
        }

        validateNoUnresolvedPlaceholders(prompt);

        return prompt;
    }

    private String loadPromptTemplate() {
        ClassPathResource resource = new ClassPathResource(PROMPT_TEMPLATE_PATH);

        if (!resource.exists()) {
            throw new PromptBuilderException(
                    "Arquivo de prompt não encontrado no classpath: " + PROMPT_TEMPLATE_PATH
            );
        }

        try {
            return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new PromptBuilderException(
                    "Erro ao carregar arquivo de prompt: " + PROMPT_TEMPLATE_PATH,
                    e
            );
        }
    }

    private String sanitizeForJsonString(String value) {
        if (value == null) {
            return "";
        }

        return value
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\r", "\\r")
                .replace("\n", "\\n")
                .replace("\t", "\\t");
    }

    private void validateNoUnresolvedPlaceholders(String prompt) {
        if (prompt.contains("{{") || prompt.contains("}}")) {
            throw new PromptBuilderException(
                    "Prompt final contém placeholders não resolvidos."
            );
        }
    }

    public static class PromptBuilderException extends RuntimeException {

        public PromptBuilderException(String message) {
            super(message);
        }

        public PromptBuilderException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}