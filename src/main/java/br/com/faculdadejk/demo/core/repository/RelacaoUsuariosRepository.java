package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.RelacaoUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacaoUsuariosRepository extends JpaRepository<RelacaoUsuarios,Long> {
}
