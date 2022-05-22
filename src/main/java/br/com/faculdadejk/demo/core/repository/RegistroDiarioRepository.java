package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario,Long> {

    @Query(value = "SELECT M FROM RegistroDiario M WHERE M.idDiario = ?1")
    Optional<RegistroDiario> findRegistroDiarioByIdDiario(Long idDiario);
}
