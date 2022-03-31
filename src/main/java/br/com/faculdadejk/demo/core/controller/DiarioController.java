package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.services.DiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/diary")
public class DiarioController {

    @Autowired
    private DiarioService diarioService;



}
