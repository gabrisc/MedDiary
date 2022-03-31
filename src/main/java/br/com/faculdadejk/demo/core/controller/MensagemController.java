package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.services.MensagemService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/msg")
@ApiResponses(value = {
        @ApiResponse(code = 200,message = "requisicao realizada com sucesso"),
        @ApiResponse(code = 400,message = "erro na requisicao")
})
public class MensagemController {

    @Autowired
    private MensagemService mensagemService;

}
