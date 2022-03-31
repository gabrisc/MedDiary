package br.com.faculdadejk.demo.core.services;

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
}
