package br.com.ideacheck.service;

import br.com.ideacheck.dto.ValidationRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PromptBuilderTest {

    private final PromptBuilder promptBuilder = new PromptBuilder();

    @Test
    void shouldBuildPromptWithUserInputData() {
        ValidationRequest request = new ValidationRequest(
                "Aplicativo para organizar documentos médicos",
                "Uma plataforma para guardar exames, receitas e laudos.",
                "Saúde",
                "Pacientes com acompanhamento médico frequente",
                "Documentos médicos ficam espalhados em vários canais."
        );

        String prompt = promptBuilder.buildPrompt(request);

        assertNotNull(prompt);
        assertTrue(prompt.contains("Aplicativo para organizar documentos médicos"));
        assertTrue(prompt.contains("Uma plataforma para guardar exames, receitas e laudos."));
        assertTrue(prompt.contains("Saúde"));
        assertTrue(prompt.contains("Pacientes com acompanhamento médico frequente"));
        assertTrue(prompt.contains("Documentos médicos ficam espalhados em vários canais."));
    }

    @Test
    void shouldReplaceAllPlaceholders() {
        ValidationRequest request = new ValidationRequest(
                "Marketplace de marmitas saudáveis",
                "Conecta produtores locais a pessoas que querem refeições saudáveis.",
                "Alimentação",
                "Pessoas que trabalham fora",
                "Falta de tempo para cozinhar."
        );

        String prompt = promptBuilder.buildPrompt(request);

        assertFalse(prompt.contains("{{titulo}}"));
        assertFalse(prompt.contains("{{descricao}}"));
        assertFalse(prompt.contains("{{segmento}}"));
        assertFalse(prompt.contains("{{publicoAlvo}}"));
        assertFalse(prompt.contains("{{problema}}"));
        assertFalse(prompt.contains("{{"));
        assertFalse(prompt.contains("}}"));
    }

    @Test
    void shouldKeepImportantOutputInstructions() {
        ValidationRequest request = new ValidationRequest(
                "App financeiro",
                "Ajuda pessoas a controlar gastos.",
                "Finanças pessoais",
                "Adultos",
                "Pessoas gastam mais do que deveriam."
        );

        String prompt = promptBuilder.buildPrompt(request);

        assertTrue(prompt.contains("Retorne exclusivamente um JSON válido"));
        assertTrue(prompt.contains("Não retorne Markdown"));
        assertTrue(prompt.contains("notaViabilidade"));
        assertTrue(prompt.contains("proximosPassos"));
    }

    @Test
    void shouldHandleNullOptionalFieldsAsEmptyStrings() {
        ValidationRequest request = new ValidationRequest(
                "Plataforma de estudos",
                "Ajuda alunos a estudarem melhor.",
                "Educação",
                null,
                null
        );

        String prompt = promptBuilder.buildPrompt(request);

        assertNotNull(prompt);
        assertTrue(prompt.contains("\"publicoAlvo\": \"\""));
        assertTrue(prompt.contains("\"problema\": \"\""));
    }

    @Test
    void shouldEscapeSpecialCharactersInUserInput() {
        ValidationRequest request = new ValidationRequest(
                "App \"inteligente\"",
                "Descrição com aspas \"teste\", quebra de linha\n e barra \\.",
                "Tecnologia",
                "Freelancers\tindependentes",
                "Usuários dizem: \"não consigo organizar\"."
        );

        String prompt = promptBuilder.buildPrompt(request);

        assertNotNull(prompt);
        assertTrue(prompt.contains("App \\\"inteligente\\\""));
        assertTrue(prompt.contains("Descrição com aspas \\\"teste\\\""));
        assertTrue(prompt.contains("quebra de linha\\n"));
        assertTrue(prompt.contains("barra \\\\."));
        assertTrue(prompt.contains("Freelancers\\tindependentes"));
        assertTrue(prompt.contains("Usuários dizem: \\\"não consigo organizar\\\"."));
    }

    @Test
    void shouldRejectNullRequest() {
        PromptBuilder.PromptBuilderException exception = assertThrows(
                PromptBuilder.PromptBuilderException.class,
                () -> promptBuilder.buildPrompt(null)
        );

        assertTrue(exception.getMessage().contains("ValidationRequest não pode ser nulo"));
    }
}