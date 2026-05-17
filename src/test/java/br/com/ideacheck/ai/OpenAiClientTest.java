package br.com.ideacheck.ai;

import br.com.ideacheck.dto.ValidationRequest;
import br.com.ideacheck.dto.ValidationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OpenAiClientTest {

    private MockWebServer mockServer;
    private OpenAiClient openAiClient;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() throws Exception {
        mockServer = new MockWebServer();
        mockServer.start();

        objectMapper = new ObjectMapper();
        String baseUrl = mockServer.url("/").toString();
        // Remove trailing slash para evitar dupla barra
        if (baseUrl.endsWith("/")) {
            baseUrl = baseUrl.substring(0, baseUrl.length() - 1);
        }

        openAiClient = new OpenAiClient("test-api-key", baseUrl, "gpt-4o-mini", objectMapper);
    }

    @AfterEach
    void tearDown() throws Exception {
        mockServer.shutdown();
    }

    @Test
    @DisplayName("Deve fazer parse correto da resposta da API OpenAI")
    void shouldParseOpenAiResponseCorrectly() {
        String aiJsonContent = """
            {
              "resumo": "App de delivery saudável.",
              "problema": "Falta de opções saudáveis.",
              "publicoAlvo": "Consumidores fitness.",
              "propostaValor": "Delivery focado em saúde.",
              "concorrenciaAlternativas": ["iFood", "UberEats"],
              "pontosFortes": ["Nicho específico"],
              "riscos": ["Logística complexa"],
              "perguntasAbertas": ["Como manter frescor?"],
              "analiseDoSegmento": "Segmento em crescimento.",
              "notaViabilidade": 7,
              "justificativaNota": "Demanda real, mas logística desafiadora.",
              "proximosPassos": ["Validar com restaurantes"]
            }
            """;

        String openAiResponse = """
            {
              "choices": [
                {
                  "message": {
                    "content": %s
                  }
                }
              ]
            }
            """.formatted(objectMapper.valueToTree(aiJsonContent).toString());

        // A API retorna o JSON como string dentro de "content"
        String properResponse = """
            {"choices":[{"message":{"content":"%s"}}]}
            """.formatted(aiJsonContent.replace("\"", "\\\"").replace("\n", "\\n"));

        mockServer.enqueue(new MockResponse()
                .setBody(properResponse)
                .addHeader("Content-Type", "application/json"));

        ValidationRequest request = new ValidationRequest(
            "Delivery saudável",
            "App de delivery de comida saudável.",
            "Alimentação",
            "Pessoas fitness",
            "Falta de opções saudáveis para delivery."
        );

        ValidationResponse response = openAiClient.analyze(request);

        assertNotNull(response);
        assertEquals("App de delivery saudável.", response.resumo());
        assertEquals(7, response.notaViabilidade());
        assertEquals(2, response.concorrenciaAlternativas().size());
    }

    @Test
    @DisplayName("Deve enviar Authorization header com API key")
    void shouldSendAuthorizationHeader() throws Exception {
        String aiContent = """
            {"resumo":"R","problema":"P","publicoAlvo":"PA","propostaValor":"PV","concorrenciaAlternativas":[],"pontosFortes":[],"riscos":[],"perguntasAbertas":[],"analiseDoSegmento":"A","notaViabilidade":5,"justificativaNota":"J","proximosPassos":[]}
            """.trim();

        String responseBody = """
            {"choices":[{"message":{"content":"%s"}}]}
            """.formatted(aiContent.replace("\"", "\\\""));

        mockServer.enqueue(new MockResponse()
                .setBody(responseBody)
                .addHeader("Content-Type", "application/json"));

        ValidationRequest request = new ValidationRequest("T", "D", "S", null, null);
        openAiClient.analyze(request);

        RecordedRequest recorded = mockServer.takeRequest();
        assertEquals("Bearer test-api-key", recorded.getHeader("Authorization"));
    }

    @Test
    @DisplayName("Deve lançar AiClientException quando API retorna erro")
    void shouldThrowExceptionOnApiError() {
        mockServer.enqueue(new MockResponse()
                .setResponseCode(500)
                .setBody("Internal Server Error"));

        ValidationRequest request = new ValidationRequest("T", "D", "S", null, null);

        assertThrows(AiClientException.class, () -> openAiClient.analyze(request));
    }
}
