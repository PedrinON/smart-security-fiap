package br.com.fiap.SmartSecurity.repository;

import br.com.fiap.SmartSecurity.model.Patrulha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatrulhaRepository extends JpaRepository<Patrulha, Long> {

    public Optional<Patrulha> findByLocalizacao(String localizacao);
    public Optional<Patrulha> findByDisponibilidade(String disponibilidade);
}
