package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.repository.DiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiarioService {

    @Autowired
    private DiarioRepository diarioRepository;

}
