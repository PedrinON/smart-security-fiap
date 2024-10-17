package br.com.fiap.SmartSecurity.dto;

import jakarta.validation.constraints.NotBlank;

public record PatrulhaCadastroDto(
        Long idPatrulha,

        @NotBlank(message = "A localização da patrulha é obrigatório!")
        String localizacao,

        @NotBlank(message = "A disponibilidade da patrulha é obrigatória!")
        String disponibilidade,

        @NotBlank(message = "A descrição da patrulha é obrigatória!")
        String descricao
) {
}
