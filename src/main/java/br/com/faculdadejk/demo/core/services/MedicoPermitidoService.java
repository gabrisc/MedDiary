package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.repository.MedicoPermitidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoPermitidoService {

    @Autowired
    private MedicoPermitidoRepository medicoPermitidoRepository;
}
