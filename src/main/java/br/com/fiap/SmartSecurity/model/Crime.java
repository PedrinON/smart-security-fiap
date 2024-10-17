package br.com.fiap.SmartSecurity.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_crime")
public class Crime {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CRIME"
    )
    @SequenceGenerator(
            name = "SEQ_CRIME",
            sequenceName = "SEQ_CRIME",
            allocationSize = 1
    )
    @Column(name = "id_crime")
    private Long idCrime;
    @Column(name = "dt_crime")
    private LocalDate dataCrime;
    private String tipo;
    private String localizacao;
    private String descricao;
    private String status;

    public Long getIdCrime() {
        return idCrime;
    }

    public void setIdCrime(Long idCrime) {
        this.idCrime = idCrime;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataCrime() {
        return dataCrime;
    }

    public void setDataCrime(LocalDate dataCrime) {
        this.dataCrime = dataCrime;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Crime crime = (Crime) o;
        return Objects.equals(idCrime, crime.idCrime) && Objects.equals(tipo, crime.tipo) && Objects.equals(dataCrime, crime.dataCrime) && Objects.equals(localizacao, crime.localizacao) && Objects.equals(descricao, crime.descricao) && Objects.equals(status, crime.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCrime, tipo, dataCrime, localizacao, descricao, status);
    }
}
