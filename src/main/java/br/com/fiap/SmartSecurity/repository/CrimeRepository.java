package br.com.fiap.SmartSecurity.repository;

import br.com.fiap.SmartSecurity.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
}
