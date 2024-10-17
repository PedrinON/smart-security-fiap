package br.com.fiap.SmartSecurity.dto;

import br.com.fiap.SmartSecurity.model.Policia;

public record PoliciaExibirDto(
        Long idPolicial,
        String nome,
        String cargo,
        String departamento,
        String telefone
) {
    public PoliciaExibirDto(Policia policia){
        this(
                policia.getIdPolicial(),
                policia.getNome(),
                policia.getCargo(),
                policia.getDepartamento(),
                policia.getTelefone());
    }
}
