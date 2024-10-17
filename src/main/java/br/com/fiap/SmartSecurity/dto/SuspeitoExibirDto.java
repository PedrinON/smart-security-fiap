package br.com.fiap.SmartSecurity.dto;

import br.com.fiap.SmartSecurity.model.Crime;
import br.com.fiap.SmartSecurity.model.Suspeito;

import java.time.LocalDate;

public record SuspeitoExibirDto(
        Long idSuspeito,
        String nome,
        Integer idade,
        String genero,
        String descricao
) {
    public SuspeitoExibirDto(Suspeito suspeito){
        this(
                suspeito.getIdSuspeito(),
                suspeito.getNome(),
                suspeito.getIdade(),
                suspeito.getGenero(),
                suspeito.getDescricao());
    }
}
