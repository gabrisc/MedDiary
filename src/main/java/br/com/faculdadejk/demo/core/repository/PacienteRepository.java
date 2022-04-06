package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository  extends JpaRepository<Paciente,Long> {
}
