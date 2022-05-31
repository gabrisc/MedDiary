package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.RegistroNotificacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroNotificacaoRepository extends JpaRepository<RegistroNotificacao,Long> {

}
