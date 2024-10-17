package br.com.fiap.SmartSecurity.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CrimeCadastroDto(
        Long idCrime,
        @NotBlank(message = "O tipo do crime é obrigatório!")
        String tipo,

        @NotNull(message = "A data do crime é obrigatória!")
        LocalDate dataCrime,

        @NotBlank(message = "A localização do crime é obrigatória!")
        String localizacao,

        @NotBlank(message = "A descrição do crime é obrigatória!")
        String descricao,

        @NotBlank(message = "O status do crime é obrigatório!")
        String status
) {
}
