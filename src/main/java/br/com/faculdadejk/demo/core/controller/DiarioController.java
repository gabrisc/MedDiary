package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.services.DiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/diary")
public class DiarioController {

    @Autowired
    private DiarioService diarioService;

}
