package br.com.ideacheck.controller;

import br.com.ideacheck.ai.AiClientException;
import br.com.ideacheck.ai.IdeaValidationService;
import br.com.ideacheck.dto.ValidationResponse;
import br.com.ideacheck.service.ValidationResponseParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.empty;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IdeaValidationController.class)
class IdeaValidationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IdeaValidationService validationService;

    private static ValidationResponse validResponse() {
        return new ValidationResponse(
                "Resumo da análise.",
                "Problema identificado.",
                "Público-alvo provável.",
                "Proposta de valor.",
                List.of("Concorrente A", "Concorrente B"),
                List.of("Ponto forte 1"),
                List.of("Risco 1"),
                List.of("Pergunta em aberto?"),
                "Análise do segmento.",
                7,
                "Justificativa da nota.",
                List.of("Próximo passo 1")
        );
    }

    @Test
    @DisplayName("Deve retornar 200 com a análise para requisição válida com todos os campos")
    void shouldReturn200ForValidRequestWithAllFields() throws Exception {
        when(validationService.validate(any())).thenReturn(validResponse());

        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "App de finanças",
                                  "descricao": "Controle de gastos mensais.",
                                  "segmento": "Finanças",
                                  "publicoAlvo": "Jovens adultos",
                                  "problema": "Dificuldade em controlar gastos."
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resumo").value("Resumo da análise."))
                .andExpect(jsonPath("$.notaViabilidade").value(7))
                .andExpect(jsonPath("$.concorrenciaAlternativas", hasSize(2)));
    }

    @Test
    @DisplayName("Deve retornar 200 quando campos opcionais são omitidos")
    void shouldReturn200WhenOptionalFieldsAreOmitted() throws Exception {
        when(validationService.validate(any())).thenReturn(validResponse());

        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "App de saúde",
                                  "descricao": "Monitoramento de saúde.",
                                  "segmento": "Saúde"
                                }
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.resumo").exists());
    }

    @Test
    @DisplayName("Deve retornar 400 quando titulo está em branco")
    void shouldReturn400WhenTituloIsBlank() throws Exception {
        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "",
                                  "descricao": "Descrição válida.",
                                  "segmento": "Tecnologia"
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.details", not(empty())));
    }

    @Test
    @DisplayName("Deve retornar 400 quando descricao está em branco")
    void shouldReturn400WhenDescricaoIsBlank() throws Exception {
        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "Título válido",
                                  "descricao": "",
                                  "segmento": "Tecnologia"
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.details", not(empty())));
    }

    @Test
    @DisplayName("Deve retornar 400 quando segmento está em branco")
    void shouldReturn400WhenSegmentoIsBlank() throws Exception {
        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "Título válido",
                                  "descricao": "Descrição válida.",
                                  "segmento": ""
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.details", not(empty())));
    }

    @Test
    @DisplayName("Deve retornar 400 com 3 detalhes quando todos os campos obrigatórios estão em branco")
    void shouldReturn400WithThreeDetailsWhenAllRequiredFieldsAreBlank() throws Exception {
        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "",
                                  "descricao": "",
                                  "segmento": ""
                                }
                                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.message").value("Campos obrigatórios ausentes ou inválidos."))
                .andExpect(jsonPath("$.details", hasSize(3)));
    }

    @Test
    @DisplayName("Deve retornar 400 para body com JSON malformado")
    void shouldReturn400ForMalformedJson() throws Exception {
        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ invalid json }"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.error").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("Requisição com formato inválido."));
    }

    @Test
    @DisplayName("Deve retornar 502 quando o serviço de IA lança AiClientException")
    void shouldReturn502WhenAiClientFails() throws Exception {
        when(validationService.validate(any()))
                .thenThrow(new AiClientException("Falha na API Gemini."));

        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "App teste",
                                  "descricao": "Descrição teste.",
                                  "segmento": "Tecnologia"
                                }
                                """))
                .andExpect(status().isBadGateway())
                .andExpect(jsonPath("$.status").value(502))
                .andExpect(jsonPath("$.error").value("Bad Gateway"))
                .andExpect(jsonPath("$.message").value("Falha na API Gemini."));
    }

    @Test
    @DisplayName("Deve retornar 502 quando o parser da IA lança ValidationResponseParseException")
    void shouldReturn502WhenParserFails() throws Exception {
        when(validationService.validate(any()))
                .thenThrow(new ValidationResponseParser.ValidationResponseParseException(
                        "Campo obrigatório ausente: resumo"));

        mockMvc.perform(post("/api/v1/validate-idea")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "titulo": "App teste",
                                  "descricao": "Descrição teste.",
                                  "segmento": "Tecnologia"
                                }
                                """))
                .andExpect(status().isBadGateway())
                .andExpect(jsonPath("$.status").value(502))
                .andExpect(jsonPath("$.error").value("Bad Gateway"))
                .andExpect(jsonPath("$.message").value("Resposta da IA fora do formato esperado."))
                .andExpect(jsonPath("$.details[0]").value("Campo obrigatório ausente: resumo"));
    }
}
