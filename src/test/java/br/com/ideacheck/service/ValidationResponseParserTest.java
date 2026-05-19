package br.com.ideacheck.service;

import br.com.ideacheck.dto.ValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ValidationResponseParserTest {

    private final ValidationResponseParser parser =
            new ValidationResponseParser(new ObjectMapper());

    @Test
    void shouldParseValidJsonResponse() {
        ValidationResponse response = parser.parse(validJson());

        assertNotNull(response);
        assertEquals("Plataforma para organizar documentos médicos.", response.resumo());
        assertEquals("Dificuldade de centralizar documentos médicos.", response.problema());
        assertEquals("Pacientes.", response.publicoAlvo());
        assertEquals("Facilitar organização e acesso a documentos médicos.", response.propostaValor());
        assertEquals(7, response.notaViabilidade());
        assertEquals("Saúde exige atenção à privacidade e confiança.", response.analiseDoSegmento());
        assertEquals("A ideia tem problema claro, mas depende de validação.", response.justificativaNota());

        assertEquals(2, response.concorrenciaAlternativas().size());
        assertEquals(2, response.pontosFortes().size());
        assertEquals(2, response.riscos().size());
        assertEquals(2, response.perguntasAbertas().size());
        assertEquals(2, response.proximosPassos().size());
    }

    @Test
    void shouldExtractJsonWhenResponseContainsTextBeforeAndAfterJson() {
        String rawResponse = """
                Claro, aqui está a análise solicitada:
                %s
                Espero que ajude.
                """.formatted(validJson());

        ValidationResponse response = parser.parse(rawResponse);

        assertNotNull(response);
        assertEquals(7, response.notaViabilidade());
        assertEquals("Plataforma para organizar documentos médicos.", response.resumo());
    }

    @Test
    void shouldRejectNullResponse() {
        assertThrowsParseException(() -> parser.parse(null));
    }

    @Test
    void shouldRejectBlankResponse() {
        assertThrowsParseException(() -> parser.parse("   "));
    }

    @Test
    void shouldRejectResponseWithoutJson() {
        assertThrowsParseException(() ->
                parser.parse("A ideia parece interessante, mas precisa de validação.")
        );
    }

    @Test
    void shouldRejectInvalidJson() {
        String invalidJson = """
                {
                  "resumo": "Ideia inválida",
                  "notaViabilidade": 7,
                }
                """;

        assertThrowsParseException(() -> parser.parse(invalidJson));
    }

    @Test
    void shouldRejectMissingRequiredField() {
        String json = validJson().replace(
                "  \"resumo\": \"Plataforma para organizar documentos médicos.\",\n",
                ""
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("Campo obrigatório ausente"));
    }

    @Test
    void shouldRejectNullRequiredField() {
        String json = validJson().replace(
                "\"resumo\": \"Plataforma para organizar documentos médicos.\"",
                "\"resumo\": null"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("Campo obrigatório ausente"));
    }

    @Test
    void shouldRejectUnexpectedField() {
        String json = validJson().replace(
                "  \"proximosPassos\": [\"Entrevistar usuários\", \"Criar protótipo\"]\n",
                "  \"proximosPassos\": [\"Entrevistar usuários\", \"Criar protótipo\"],\n" +
                        "  \"campoExtra\": \"não permitido\"\n"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("Campo não previsto"));
    }

    @Test
    void shouldRejectTextFieldThatIsNotString() {
        String json = validJson().replace(
                "\"resumo\": \"Plataforma para organizar documentos médicos.\"",
                "\"resumo\": 123"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("Campo deve ser string"));
    }

    @Test
    void shouldRejectListFieldThatIsNotArray() {
        String json = validJson().replace(
                "\"riscos\": [\"Privacidade de dados\", \"Adoção pelos usuários\"]",
                "\"riscos\": \"Privacidade de dados\""
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("Campo deve ser array"));
    }

    @Test
    void shouldRejectListWithNonStringItem() {
        String json = validJson().replace(
                "\"riscos\": [\"Privacidade de dados\", \"Adoção pelos usuários\"]",
                "\"riscos\": [\"Privacidade de dados\", 123]"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("Todos os itens do campo devem ser strings"));
    }

    @Test
    void shouldRejectListWithMoreThanFiveItems() {
        String json = validJson().replace(
                "\"proximosPassos\": [\"Entrevistar usuários\", \"Criar protótipo\"]",
                "\"proximosPassos\": [\"Item 1\", \"Item 2\", \"Item 3\", \"Item 4\", \"Item 5\", \"Item 6\"]"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("excede o limite"));
    }

    @Test
    void shouldRejectNotaViabilidadeAsString() {
        String json = validJson().replace(
                "\"notaViabilidade\": 7",
                "\"notaViabilidade\": \"7\""
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("número inteiro"));
    }

    @Test
    void shouldRejectNotaViabilidadeAsDecimal() {
        String json = validJson().replace(
                "\"notaViabilidade\": 7",
                "\"notaViabilidade\": 7.5"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("número inteiro"));
    }

    @Test
    void shouldRejectNotaViabilidadeBelowZero() {
        String json = validJson().replace(
                "\"notaViabilidade\": 7",
                "\"notaViabilidade\": -1"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("entre 0 e 10"));
    }

    @Test
    void shouldRejectNotaViabilidadeAboveTen() {
        String json = validJson().replace(
                "\"notaViabilidade\": 7",
                "\"notaViabilidade\": 11"
        );

        ValidationResponseParser.ValidationResponseParseException exception =
                assertThrowsParseException(() -> parser.parse(json));

        assertTrue(exception.getMessage().contains("entre 0 e 10"));
    }

    @Test
    void shouldAcceptEmptyStringsAndEmptyListsWhenSchemaIsValid() {
        String json = """
                {
                  "resumo": "",
                  "problema": "",
                  "publicoAlvo": "",
                  "propostaValor": "",
                  "concorrenciaAlternativas": [],
                  "pontosFortes": [],
                  "riscos": [],
                  "perguntasAbertas": [],
                  "analiseDoSegmento": "",
                  "notaViabilidade": 0,
                  "justificativaNota": "",
                  "proximosPassos": []
                }
                """;

        ValidationResponse response = parser.parse(json);

        assertNotNull(response);
        assertEquals("", response.resumo());
        assertEquals("", response.problema());
        assertEquals("", response.publicoAlvo());
        assertEquals("", response.propostaValor());
        assertEquals("", response.analiseDoSegmento());
        assertEquals("", response.justificativaNota());
        assertEquals(0, response.notaViabilidade());

        assertTrue(response.concorrenciaAlternativas().isEmpty());
        assertTrue(response.pontosFortes().isEmpty());
        assertTrue(response.riscos().isEmpty());
        assertTrue(response.perguntasAbertas().isEmpty());
        assertTrue(response.proximosPassos().isEmpty());
    }

    private ValidationResponseParser.ValidationResponseParseException assertThrowsParseException(
            Executable executable
    ) {
        return assertThrows(
                ValidationResponseParser.ValidationResponseParseException.class,
                executable
        );
    }

    private String validJson() {
        return """
                {
                  "resumo": "Plataforma para organizar documentos médicos.",
                  "problema": "Dificuldade de centralizar documentos médicos.",
                  "publicoAlvo": "Pacientes.",
                  "propostaValor": "Facilitar organização e acesso a documentos médicos.",
                  "concorrenciaAlternativas": ["Pastas em nuvem", "Armazenamento manual"],
                  "pontosFortes": ["Problema claro", "Público identificável"],
                  "riscos": ["Privacidade de dados", "Adoção pelos usuários"],
                  "perguntasAbertas": ["Quem pagaria?", "Quais documentos priorizar?"],
                  "analiseDoSegmento": "Saúde exige atenção à privacidade e confiança.",
                  "notaViabilidade": 7,
                  "justificativaNota": "A ideia tem problema claro, mas depende de validação.",
                  "proximosPassos": ["Entrevistar usuários", "Criar protótipo"]
                }
                """;
    }
}