package br.com.fiap.SmartSecurity.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_suspeito")
public class Suspeito {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_SUSPEITO"
    )
    @SequenceGenerator(
            name = "SEQ_SUSPEITO",
            sequenceName = "SEQ_SUSPEITO",
            allocationSize = 1
    )
    @Column(name = "id_suspeito")
    private Long idSuspeito;
    private String nome;
    private Integer idade;
    private String genero;
    private String descricao;

    public Long getIdSuspeito() {
        return idSuspeito;
    }

    public void setIdSuspeito(Long idSuspeito) {
        this.idSuspeito = idSuspeito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
        Suspeito suspeito = (Suspeito) o;
        return Objects.equals(idSuspeito, suspeito.idSuspeito) && Objects.equals(nome, suspeito.nome) && Objects.equals(idade, suspeito.idade) && Objects.equals(genero, suspeito.genero) && Objects.equals(descricao, suspeito.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSuspeito, nome, idade, genero, descricao);
    }
}
