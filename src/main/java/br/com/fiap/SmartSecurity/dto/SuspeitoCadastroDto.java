package br.com.fiap.SmartSecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record SuspeitoCadastroDto(
        Long idCrime,

        @NotBlank(message = "O nome do suspeito é obrigatório!")
        String nome,

        @NotNull(message = "A idade do suspeito é obrigatório!")
        Integer idade,

        @NotBlank(message = "O genero do suspeito é obrigatório!")
        String genero,

        @NotBlank(message = "A descrição do suspeito é obrigatória!")
        String descricao
) {
}
