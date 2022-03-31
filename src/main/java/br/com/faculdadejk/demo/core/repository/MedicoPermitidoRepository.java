package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.MedicoPermitido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoPermitidoRepository extends JpaRepository<MedicoPermitido,Long> {
}
