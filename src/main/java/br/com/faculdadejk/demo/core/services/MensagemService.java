package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;
}
