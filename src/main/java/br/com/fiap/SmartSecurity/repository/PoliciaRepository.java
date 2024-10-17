package br.com.fiap.SmartSecurity.repository;

import br.com.fiap.SmartSecurity.model.Policia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PoliciaRepository extends JpaRepository<Policia, Long> {

    public Optional<Policia> findByCargo(String cargo);

    public  Optional<Policia> findByDepartamento(String departamento);
}
