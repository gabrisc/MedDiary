package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {

    public static final String USUARIO_NOT_FOUND = "Não foi possivel encontrar o usuario";
    @Autowired
    private UsuarioRepository usuarioRepository;

//    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Usuario login(String nome, String senha) {

//        String senhaConvertida = bCryptPasswordEncoder.encode(senha);
        Optional<Usuario> usuario = usuarioRepository.findUsuarioByUsernameAndPassword(nome, senha);

        return usuario.orElseThrow(()->new NotFoundException(USUARIO_NOT_FOUND));
    }

    public Usuario novoUsuario(Usuario usuarioNovo) {
        usuarioNovo.setDataCriacao(new Date());
//        usuarioNovo.setPassword(bCryptPasswordEncoder.encode(usuarioNovo.getPassword()));

        return usuarioRepository.save(usuarioNovo);
    }

    public Usuario atualizarUsuario(Usuario usuarioAlterado) {
        if (usuarioRepository.existsById(usuarioAlterado.getIdUsuario())) {
            return usuarioRepository.save(usuarioAlterado);
        } else {
            throw new NotFoundException(USUARIO_NOT_FOUND);
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
        return usuarioRepository.findById(id)
                                .orElseThrow(() -> new NotFoundException(USUARIO_NOT_FOUND));
    };

    public Usuario findUsuarioByUsername(String username) {
        return usuarioRepository.findUsuarioByUsername(username)
                                .orElseThrow(() -> new NotFoundException(USUARIO_NOT_FOUND));
    }

}
