package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Diario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DiarioRepository extends JpaRepository<Diario,Long> {

    @Query(value = "SELECT D FROM Diario D WHERE D.idUsuario.id = ?1")
    Optional<Diario> findByIdUsuario(Long idUsuario);

    //Optional<Diario> findByIdUsuario(Long idUsuario);
}
