package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Diario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiarioRepository extends JpaRepository<Diario,Long> {
}
