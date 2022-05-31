package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao,Long> {

    List<Notificacao> findAllByIdUsuarioId(Long id);
}
