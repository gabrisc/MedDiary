package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.services.MensagemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/msg")

public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

}
