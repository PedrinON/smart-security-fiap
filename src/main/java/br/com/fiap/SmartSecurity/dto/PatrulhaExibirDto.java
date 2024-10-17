package br.com.fiap.SmartSecurity.dto;

import br.com.fiap.SmartSecurity.model.Patrulha;

public record PatrulhaExibirDto(
        Long idPatrulha,
        String localizacao,
        String disponibilidade,
        String descricao
) {
    public PatrulhaExibirDto(Patrulha patrulha){
        this(
                patrulha.getIdPatrulha(),
                patrulha.getLocalizacao(),
                patrulha.getDisponibilidade(),
                patrulha.getDescricao());
    }
}
