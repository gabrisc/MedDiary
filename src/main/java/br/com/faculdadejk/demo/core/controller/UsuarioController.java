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
import org.springframework.web.bind.annotation.*;

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


    @PostMapping(value = "/create",
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.saveUsuario(usuario);
    }

    @PutMapping(value = "/update",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario updateDadosPessoais(@RequestBody Usuario usuario) {
        return usuarioService.updateDadosPessoais(usuario);
    }

    @PostMapping(value = "/updatePassword",
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateSenha(@RequestBody String senha) {

    }

    @PostMapping(value = "/updateLogin",
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateLogin() {
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUsuario(@PathVariable(value = "id") Long id) {
        usuarioService.delete(id);
    }

}
