package br.com.ideacheck.ai;

import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IdeaValidationServiceTest {

    @Mock
    private AiClient aiClient;

    private IdeaValidationService service;

    @BeforeEach
    void setUp() {
        service = new IdeaValidationService(aiClient);
    }

    @Test
    @DisplayName("Deve delegar a análise ao AiClient e retornar a resposta")
    void shouldDelegateToAiClientAndReturnResponse() {
        ValidationRequest request = new ValidationRequest(
            "App de finanças pessoais",
            "Aplicativo para controle de gastos.",
            "Finanças",
            "Jovens adultos",
            "Dificuldade em controlar gastos mensais."
        );

        ValidationResponse expectedResponse = new ValidationResponse(
            "App para controle financeiro pessoal.",
            "Dificuldade em controlar gastos mensais.",
            "Jovens adultos.",
            "Facilitar o controle financeiro pessoal.",
            List.of("Nubank", "Mobills", "Organizze"),
            List.of("Problema comum", "Público amplo"),
            List.of("Mercado competitivo", "Retenção de usuários"),
            List.of("Qual o diferencial?"),
            "Segmento de finanças pessoais é competitivo mas com demanda constante.",
            6,
            "Mercado validado, mas alta concorrência exige diferencial claro.",
            List.of("Pesquisar concorrentes", "Definir diferencial")
        );

        when(aiClient.analyze(request)).thenReturn(expectedResponse);

        ValidationResponse result = service.validate(request);

        assertEquals(expectedResponse, result);
        verify(aiClient, times(1)).analyze(request);
    }

    @Test
    @DisplayName("Deve propagar exceção quando AiClient falha")
    void shouldPropagateExceptionWhenAiClientFails() {
        ValidationRequest request = new ValidationRequest(
            "Teste",
            "Descrição",
            "Tech",
            null,
            null
        );

        when(aiClient.analyze(request)).thenThrow(new AiClientException("Falha na API"));

        assertThrows(AiClientException.class, () -> service.validate(request));
        verify(aiClient, times(1)).analyze(request);
    }

    @Test
    @DisplayName("Deve chamar analyze exatamente uma vez por validação")
    void shouldCallAnalyzeExactlyOnce() {
        ValidationRequest request = new ValidationRequest(
            "Ideia X",
            "Desc X",
            "Educação",
            "Professores",
            "Falta de material"
        );

        ValidationResponse mockResponse = new ValidationResponse(
            "Resumo", "Problema", "Público", "Proposta",
            List.of(), List.of(), List.of(), List.of(),
            "Análise", 5, "Justificativa", List.of()
        );

        when(aiClient.analyze(request)).thenReturn(mockResponse);

        service.validate(request);

        verify(aiClient, times(1)).analyze(request);
        verifyNoMoreInteractions(aiClient);
    }
}
