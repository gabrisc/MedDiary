package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query(value = "SELECT U FROM Usuario U WHERE U.username = ?1 AND U.password = ?2")
    Optional<Usuario> findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT U FROM Usuario U WHERE U.username = ?1")
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);

    @Transactional
    void deleteByUsername(String username);

}
