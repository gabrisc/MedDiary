package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query(value = "SELECT U FROM Usuario U WHERE U.username = ?1")
    Optional<Usuario> findUsuarioByUsernameAndPassword(String username);

}
