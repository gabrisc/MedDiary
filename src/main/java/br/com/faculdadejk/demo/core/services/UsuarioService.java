package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> findBy(Long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Usuario saveUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario updateDadosPessoais(Usuario usuario) {
        Usuario usuarioSalvo = findBy(usuario.getIdUsuario()).orElseThrow(() -> new NotFoundException("Usuario não foi encontrado"));

        usuarioSalvo.setCpf(usuario.getCpf());
        usuarioSalvo.setNomeCompleto(usuario.getNomeCompleto());

        usuarioRepository.save(usuarioSalvo);

        return usuarioSalvo;
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
