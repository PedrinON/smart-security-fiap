package br.com.fiap.SmartSecurity.repository;

import br.com.fiap.SmartSecurity.model.Suspeito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SuspeitoRepository extends JpaRepository<Suspeito, Long> {

    public Optional<Suspeito> findByNome(String nome);
}
