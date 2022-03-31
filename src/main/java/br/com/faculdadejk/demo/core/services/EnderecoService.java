package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.repository.EnderecorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecorRepository enderecorRepository;
}
