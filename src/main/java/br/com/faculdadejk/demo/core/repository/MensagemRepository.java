package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem,Long> {
}
