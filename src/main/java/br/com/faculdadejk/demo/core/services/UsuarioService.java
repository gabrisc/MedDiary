package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario novoUsuario(Usuario usuarioNovo) {
        usuarioNovo.setDataCriacao(new Date());
        return usuarioRepository.save(usuarioNovo);
    }

    public Usuario atualizarUsuario(Usuario usuarioAlterado) {
        if (usuarioRepository.existsById(usuarioAlterado.getIdUsuario())){
            return usuarioRepository.save(usuarioAlterado)    ;
        } else {
            throw new NotFoundException("Não foi possivel encontrar o usuario");
        }
    }

    public HttpStatus ApagarUsuario(Long usuarioId) {
        if (Objects.nonNull(usuarioId)) {
            usuarioRepository.deleteById(usuarioId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar o usuario"));
    };

    public Usuario findUsuarioByUsername(String username) {
        return usuarioRepository.findUsuarioByUsernameAndPassword(username).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar o usuario"));
    }

}
