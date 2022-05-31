package br.com.faculdadejk.demo.core.repository;

import br.com.faculdadejk.demo.core.model.RegistroPessoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroPessoalRepository extends JpaRepository<RegistroPessoal,Long> {
}
