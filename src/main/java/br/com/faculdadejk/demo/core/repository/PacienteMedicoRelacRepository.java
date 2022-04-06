package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.PacienteMedicoRelac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteMedicoRelacRepository extends JpaRepository<PacienteMedicoRelac,Long> {
}
