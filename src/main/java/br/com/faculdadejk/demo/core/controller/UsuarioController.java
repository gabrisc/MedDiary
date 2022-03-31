package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.services.MedicoPermitidoService;
import br.com.faculdadejk.demo.core.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(name = "/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MedicoPermitidoService medicoPermitidoService;

    @RequestMapping(value = "/findById/{id}",
                    method = RequestMethod.GET,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Usuario findById(@PathVariable(value = "idUsuario")Long idUsuario) {
        return usuarioService.findBy(idUsuario).orElseThrow(() -> new NotFoundException("Usuario não foi encontrado"));
    }

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

    public void updateSenha() {

    }

    public void updateLogin() {

    }

    public void bloquearUsuario() {

    }

    public void retirarMedico() {

    }

    public void adicionarNovoMedico() {

    }



    @RequestMapping(value = "/{id}",
                    method = RequestMethod.DELETE)
    public void deleteUsuario(@PathVariable(value = "id") Long id) {
        usuarioService.delete(id);
    }

}
