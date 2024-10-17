package br.com.fiap.SmartSecurity.dto;

import br.com.fiap.SmartSecurity.model.Crime;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record CrimeExibirDto(
        Long idCrime,
        String tipo,
        LocalDate dataCrime,
        String localizacao,
        String descricao,
        String status
) {
    public CrimeExibirDto(Crime crime){
        this(
                crime.getIdCrime(),
                crime.getTipo(),
                crime.getDataCrime(),
                crime.getLocalizacao(),
                crime.getDescricao(),
                crime.getStatus());
    }
}
