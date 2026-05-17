package br.com.ideacheck.dto;

import jakarta.validation.constraints.NotBlank;

public record ValidationRequest(
    @NotBlank String titulo,
    @NotBlank String descricao,
    @NotBlank String segmento,
    String publicoAlvo,
    String problema
) {
    // TODO: adicionar @Size, @Pattern e mensagens customizadas
}
