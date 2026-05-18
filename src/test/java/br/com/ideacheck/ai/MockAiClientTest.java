package br.com.ideacheck.ai;

import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MockAiClientTest {

    private MockAiClient mockAiClient;

    @BeforeEach
    void setUp() {
        mockAiClient = new MockAiClient();
    }

    @Test
    @DisplayName("Deve retornar resposta com todos os campos preenchidos")
    void shouldReturnCompleteResponse() {
        ValidationRequest request = new ValidationRequest(
            "App de delivery de comida saudável",
            "Plataforma para conectar restaurantes saudáveis a consumidores.",
            "Alimentação",
            "Pessoas que buscam alimentação saudável",
            "Dificuldade de encontrar opções saudáveis para delivery."
        );

        ValidationResponse response = mockAiClient.analyze(request);

        assertNotNull(response);
        assertNotNull(response.resumo());
        assertNotNull(response.problema());
        assertNotNull(response.publicoAlvo());
        assertNotNull(response.propostaValor());
        assertNotNull(response.concorrenciaAlternativas());
        assertNotNull(response.pontosFortes());
        assertNotNull(response.riscos());
        assertNotNull(response.perguntasAbertas());
        assertNotNull(response.analiseDoSegmento());
        assertNotNull(response.justificativaNota());
        assertNotNull(response.proximosPassos());
        assertTrue(response.notaViabilidade() >= 0 && response.notaViabilidade() <= 10);
    }

    @Test
    @DisplayName("Deve usar título do request no resumo")
    void shouldUseTitleInSummary() {
        ValidationRequest request = new ValidationRequest(
            "Marketplace de freelancers",
            "Plataforma para conectar freelancers a empresas.",
            "Tecnologia",
            null,
            null
        );

        ValidationResponse response = mockAiClient.analyze(request);

        assertTrue(response.resumo().contains("Marketplace de freelancers"));
    }

    @Test
    @DisplayName("Deve tratar campos opcionais nulos")
    void shouldHandleNullOptionalFields() {
        ValidationRequest request = new ValidationRequest(
            "Ideia teste",
            "Descrição teste",
            "Educação",
            null,
            null
        );

        ValidationResponse response = mockAiClient.analyze(request);

        assertNotNull(response);
        assertEquals("Público-alvo não especificado.", response.publicoAlvo());
        assertEquals("Problema não especificado pelo usuário.", response.problema());
    }

    @Test
    @DisplayName("Deve respeitar limite máximo de 5 itens por lista")
    void shouldRespectMaxListSize() {
        ValidationRequest request = new ValidationRequest(
            "Teste",
            "Descrição",
            "Saúde",
            "Médicos",
            "Problema X"
        );

        ValidationResponse response = mockAiClient.analyze(request);

        assertTrue(response.concorrenciaAlternativas().size() <= 5);
        assertTrue(response.pontosFortes().size() <= 5);
        assertTrue(response.riscos().size() <= 5);
        assertTrue(response.perguntasAbertas().size() <= 5);
        assertTrue(response.proximosPassos().size() <= 5);
    }
}
