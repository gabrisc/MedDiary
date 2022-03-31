package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecorRepository extends JpaRepository<Endereco,Long> {
}
