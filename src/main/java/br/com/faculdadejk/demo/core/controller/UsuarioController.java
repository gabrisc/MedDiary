package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.services.MedicoPermitidoService;
import br.com.faculdadejk.demo.core.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "UsuarioEndPoint")
@RestController
@RequestMapping("/v1")
@ApiResponses(value = {
        @ApiResponse(code = 200,message = "requisicao realizada com sucesso"),
        @ApiResponse(code = 400,message = "erro na requisicao")
})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MedicoPermitidoService medicoPermitidoService;

    @ApiOperation(value = "o que isso faz?",produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/findById/{id}",
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario findById(@PathVariable(value = "idUsuario")Long idUsuario) {
        return usuarioService.findBy(idUsuario).orElseThrow(() -> new NotFoundException("Usuario não foi encontrado"));
    }
/*

    @RequestMapping(method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @RequestMapping(value = "update/",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario updateDadosPessoais(@RequestBody Usuario usuario) {
        return usuarioService.updateDadosPessoais(usuario);
    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateSenha(@RequestBody String senha) {

    }

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLogin() {

    }

    public void bloquearUsuario() {

    }

    public void deleteMedico() {

    }

    public void addNovoMedico() {

    }

    @RequestMapping(value = "/{id}",
                    method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable(value = "id") Long id) {
        usuarioService.delete(id);
    }
*/
}
