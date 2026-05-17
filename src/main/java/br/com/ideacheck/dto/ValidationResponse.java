package br.com.ideacheck.dto;

import java.util.List;

public record ValidationResponse(
    String resumo,
    String problema,
    String publicoAlvo,
    String propostaValor,
    List<String> concorrenciaAlternativas,
    List<String> pontosFortes,
    List<String> riscos,
    List<String> perguntasAbertas,
    String analiseDoSegmento,
    int notaViabilidade,
    String justificativaNota,
    List<String> proximosPassos
) {
}
