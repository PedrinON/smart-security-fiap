package br.com.fiap.SmartSecurity.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_policial")
public class Policia {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_POLICIAL"
    )
    @SequenceGenerator(
            name = "SEQ_POLICIAL",
            sequenceName = "SEQ_POLICIAL",
            allocationSize = 1
    )
    @Column(name = "id_policial")
    private Long idPolicial;
    private String nome;
    private String cargo;
    private String departamento;
    private String telefone;

    public Long getIdPolicial() {
        return idPolicial;
    }

    public void setIdPolicial(Long idPolicial) {
        this.idPolicial = idPolicial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Policia policia = (Policia) o;
        return Objects.equals(idPolicial, policia.idPolicial) && Objects.equals(nome, policia.nome) && Objects.equals(cargo, policia.cargo) && Objects.equals(departamento, policia.departamento) && Objects.equals(telefone, policia.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPolicial, nome, cargo, departamento, telefone);
    }
}
