package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(tags = "UsuarioEndPoint")
@RestController
@RequestMapping("/user")
@ApiResponses(value = {
        @ApiResponse(code = 200,message = "requisicao realizada com sucesso"),
        @ApiResponse(code = 400,message = "erro na requisicao")
})
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @ApiOperation(value = "(CREATE) - Criação de um novo Usuario do tipo paciente",
                  produces = MediaType.APPLICATION_JSON_VALUE,
                  consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/create")
    public Usuario novoUsuario(@RequestBody Usuario usuarioPaciente) {
        return usuarioService.novoUsuario(usuarioPaciente);
    }

    @ApiOperation(value = "(UPDATE) - Realiza um Update nos dados pessoais do paciente",
                  consumes = MediaType.APPLICATION_JSON_VALUE,
                  produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/update")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(usuario);
    }

    @ApiOperation(value = "(DELETE) - Deletar um Usuario",
                  consumes = MediaType.APPLICATION_JSON_VALUE)
    @DeleteMapping(value = "/delete/{id}")
    public HttpStatus deleteUsuario(@PathVariable(value = "id") Long id) {
        return usuarioService.ApagarUsuario(id);
    }

    @ApiOperation(value = "(READ) - Procurar por ID",
                  produces = MediaType.APPLICATION_JSON_VALUE,
                  consumes = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/findById/{idUsuario}")
    public Usuario findUsuarioById(@PathVariable(value = "idUsuario")Long idUsuario) {
        return usuarioService.findUsuarioById(idUsuario);
    }

    @ApiOperation(value = "(READ) - Procurar por USERNAME",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping(value = "/findUsuarioByUsername/{username}")
    public Usuario findUsuarioByUsername(@PathVariable(value = "username")String username) {
        return usuarioService.findUsuarioByUsername(username);
    }

}
