package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico,Long> {
}
