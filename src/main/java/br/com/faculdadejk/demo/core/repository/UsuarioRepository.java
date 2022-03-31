package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
