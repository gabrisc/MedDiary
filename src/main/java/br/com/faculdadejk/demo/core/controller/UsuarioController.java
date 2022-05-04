package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.mapper.UsuarioMapper;
import br.com.faculdadejk.demo.core.model.Usuario;
import org.springframework.security.crypto.password.PasswordEncoder;
import br.com.faculdadejk.demo.core.model.vo.UsuarioVO;
import br.com.faculdadejk.demo.core.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

//    private final PasswordEncoder encoder;
//
//    public UsuarioController(UsuarioService usuarioService, PasswordEncoder encoder) {
//        this.usuarioService = usuarioService;
//        this.encoder = encoder;
//    }


//    @ApiOperation(value = "(READ) - Login Usuario do tipo paciente",
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    @GetMapping(value = "/login")
//    public ResponseEntity<Boolean> login(@RequestParam String nomeUsuario, @RequestParam String senha) {
//
//        Optional<UsuarioVO> optUsuario = UsuarioMapper.INSTANCE.toUsuarioVo(
//                                        usuarioService.login(nomeUsuario, senha));
//        if (optUsuario.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
//        }
//
//        UsuarioVO usuario = optUsuario.get();
//        boolean valid = encoder.matches(senha, usuario.getPassword());
//
//        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
//
//
//        return  ResponseEntity.status(status).body(valid);
//    }

    @ApiOperation(value = "(CREATE) - Criação de um novo Usuario do tipo paciente",
                  produces = MediaType.APPLICATION_JSON_VALUE,
                  consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/create")
    public UsuarioVO novoUsuario(@RequestBody UsuarioVO usuarioPaciente) {
        return UsuarioMapper.INSTANCE.toUsuarioVo(
                usuarioService.novoUsuario(
                        UsuarioMapper.INSTANCE.toUsuario(usuarioPaciente)));
    }

    @ApiOperation(value = "(UPDATE) - Realiza um Update nos dados pessoais do paciente",
                  consumes = MediaType.APPLICATION_JSON_VALUE,
                  produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(value = "/update")
    public UsuarioVO atualizarUsuario(@RequestBody UsuarioVO usuario) {
        return UsuarioMapper.INSTANCE.toUsuarioVo(
                usuarioService.atualizarUsuario(
                        UsuarioMapper.INSTANCE.toUsuario(usuario)));
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
