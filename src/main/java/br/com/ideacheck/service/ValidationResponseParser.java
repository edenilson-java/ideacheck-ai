package br.com.ideacheck.service;

import br.com.ideacheck.dto.ValidationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ValidationResponseParser {

    private static final int MIN_NOTA_VIABILIDADE = 0;
    private static final int MAX_NOTA_VIABILIDADE = 10;
    private static final int MAX_LIST_ITEMS = 5;

    private static final Set<String> REQUIRED_FIELDS = Set.of(
            "resumo",
            "problema",
            "publicoAlvo",
            "propostaValor",
            "concorrenciaAlternativas",
            "pontosFortes",
            "riscos",
            "perguntasAbertas",
            "analiseDoSegmento",
            "notaViabilidade",
            "justificativaNota",
            "proximosPassos"
    );

    private static final Set<String> STRING_FIELDS = Set.of(
            "resumo",
            "problema",
            "publicoAlvo",
            "propostaValor",
            "analiseDoSegmento",
            "justificativaNota"
    );

    private static final Set<String> LIST_FIELDS = Set.of(
            "concorrenciaAlternativas",
            "pontosFortes",
            "riscos",
            "perguntasAbertas",
            "proximosPassos"
    );

    private final ObjectMapper objectMapper;

    public ValidationResponseParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ValidationResponse parse(String aiResponse) {
        if (aiResponse == null || aiResponse.isBlank()) {
            throw new ValidationResponseParseException("Resposta da IA vazia ou nula.");
        }

        String json = extractJsonObject(aiResponse);

        JsonNode root = readJson(json);

        validateRootObject(root);
        validateRequiredFields(root);
        validateNoUnexpectedFields(root);
        validateStringFields(root);
        validateListFields(root);
        validateNotaViabilidade(root);

        return new ValidationResponse(
                getText(root, "resumo"),
                getText(root, "problema"),
                getText(root, "publicoAlvo"),
                getText(root, "propostaValor"),
                getStringList(root, "concorrenciaAlternativas"),
                getStringList(root, "pontosFortes"),
                getStringList(root, "riscos"),
                getStringList(root, "perguntasAbertas"),
                getText(root, "analiseDoSegmento"),
                root.get("notaViabilidade").asInt(),
                getText(root, "justificativaNota"),
                getStringList(root, "proximosPassos")
        );
    }

    private String extractJsonObject(String rawResponse) {
        String trimmed = rawResponse.trim();

        if (trimmed.startsWith("{") && trimmed.endsWith("}")) {
            return trimmed;
        }

        int start = trimmed.indexOf('{');
        int end = trimmed.lastIndexOf('}');

        if (start < 0 || end < 0 || end <= start) {
            throw new ValidationResponseParseException(
                    "Resposta da IA não contém um objeto JSON válido."
            );
        }

        String possibleJson = trimmed.substring(start, end + 1).trim();

        if (!possibleJson.startsWith("{") || !possibleJson.endsWith("}")) {
            throw new ValidationResponseParseException(
                    "Não foi possível extrair um objeto JSON da resposta da IA."
            );
        }

        return possibleJson;
    }

    private JsonNode readJson(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            throw new ValidationResponseParseException(
                    "Resposta da IA não é um JSON válido.",
                    e
            );
        }
    }

    private void validateRootObject(JsonNode root) {
        if (root == null || !root.isObject()) {
            throw new ValidationResponseParseException(
                    "Resposta da IA deve ser um objeto JSON."
            );
        }
    }

    private void validateRequiredFields(JsonNode root) {
        for (String field : REQUIRED_FIELDS) {
            if (!root.has(field) || root.get(field).isNull()) {
                throw new ValidationResponseParseException(
                        "Campo obrigatório ausente ou nulo na resposta da IA: " + field
                );
            }
        }
    }

    private void validateNoUnexpectedFields(JsonNode root) {
        root.fieldNames().forEachRemaining(field -> {
            if (!REQUIRED_FIELDS.contains(field)) {
                throw new ValidationResponseParseException(
                        "Campo não previsto no contrato da resposta: " + field
                );
            }
        });
    }

    private void validateStringFields(JsonNode root) {
        for (String field : STRING_FIELDS) {
            JsonNode value = root.get(field);

            if (!value.isTextual()) {
                throw new ValidationResponseParseException(
                        "Campo deve ser string: " + field
                );
            }
        }
    }

    private void validateListFields(JsonNode root) {
        for (String field : LIST_FIELDS) {
            JsonNode value = root.get(field);

            if (!value.isArray()) {
                throw new ValidationResponseParseException(
                        "Campo deve ser array: " + field
                );
            }

            if (value.size() > MAX_LIST_ITEMS) {
                throw new ValidationResponseParseException(
                        "Campo excede o limite de " + MAX_LIST_ITEMS + " itens: " + field
                );
            }

            for (JsonNode item : value) {
                if (!item.isTextual()) {
                    throw new ValidationResponseParseException(
                            "Todos os itens do campo devem ser strings: " + field
                    );
                }
            }
        }
    }

    private void validateNotaViabilidade(JsonNode root) {
        JsonNode nota = root.get("notaViabilidade");

        if (!nota.isIntegralNumber()) {
            throw new ValidationResponseParseException(
                    "Campo notaViabilidade deve ser número inteiro."
            );
        }

        int value = nota.asInt();

        if (value < MIN_NOTA_VIABILIDADE || value > MAX_NOTA_VIABILIDADE) {
            throw new ValidationResponseParseException(
                    "Campo notaViabilidade deve estar entre "
                            + MIN_NOTA_VIABILIDADE
                            + " e "
                            + MAX_NOTA_VIABILIDADE
                            + "."
            );
        }
    }

    private String getText(JsonNode root, String field) {
        return root.get(field).asText();
    }

    private List<String> getStringList(JsonNode root, String field) {
        return objectMapper.convertValue(
                root.get(field),
                objectMapper.getTypeFactory().constructCollectionType(List.class, String.class)
        );
    }

    public static class ValidationResponseParseException extends RuntimeException {

        public ValidationResponseParseException(String message) {
            super(message);
        }

        public ValidationResponseParseException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}