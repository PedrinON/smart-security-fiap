package br.com.fiap.SmartSecurity.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_patrulha")
public class Patrulha {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_PATRULHA"
    )
    @SequenceGenerator(
            name = "SEQ_PATRULHA",
            sequenceName = "SEQ_PATRULHA",
            allocationSize = 1
    )
    @Column(name = "id_patrulha")
    private Long idPatrulha;
    private String localizacao;
    private String disponibilidade;
    private String descricao;

    public Long getIdPatrulha() {
        return idPatrulha;
    }

    public void setIdPatrulha(Long idPatrulha) {
        this.idPatrulha = idPatrulha;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patrulha patrulha = (Patrulha) o;
        return Objects.equals(idPatrulha, patrulha.idPatrulha) && Objects.equals(localizacao, patrulha.localizacao) && Objects.equals(disponibilidade, patrulha.disponibilidade) && Objects.equals(descricao, patrulha.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPatrulha, localizacao, disponibilidade, descricao);
    }
}
