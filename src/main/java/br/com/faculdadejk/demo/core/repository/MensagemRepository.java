package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem,Long> {

    @Query(value = "SELECT M FROM Mensagem M WHERE M.idDiario = ?1")
    Optional<Mensagem> findMensagemByIdDiario(Long idDiario);
}
