package br.com.fiap.SmartSecurity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

public record PoliciaCadastroDto(
        Long idPolicial,

        @NotBlank(message = "O nome do policial é obrigatório!")
        String nome,

        @NotBlank(message = "O cargo é obrigatório!")
        String cargo,

        @NotBlank(message = "O departamento é obrigatório!")
        String departamento,

        @NotNull(message = "O número do telefone do policial é obrigatório!")
        String telefone
) {
}
