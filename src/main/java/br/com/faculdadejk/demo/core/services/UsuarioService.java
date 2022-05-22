package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.CustomException;
import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.repository.UsuarioRepository;
import br.com.faculdadejk.demo.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

;import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, usuarioRepository.findByUsername(username).get().getUsuarioEnumRules());
        } catch (AuthenticationException e) {
            throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public String signup(Usuario usuario) {
        if (!usuarioRepository.existsByUsername(usuario.getUsername())) {
            usuario.setDataCriacao(LocalDateTime.now());
            usuario.setDataAlteracao(LocalDateTime.now());
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            usuarioRepository.save(usuario);
            return jwtTokenProvider.createToken(usuario.getUsername(), usuario.getUsuarioEnumRules());
        } else {
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    public void delete(String username) {
        usuarioRepository.deleteByUsername(username);
    }

    public Usuario search(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username).orElseThrow(()-> new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND));
        return usuario;
    }

    public Usuario whoami(HttpServletRequest req) {
        return usuarioRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req))).orElseThrow(()->new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, usuarioRepository.findByUsername(username).get().getUsuarioEnumRules());
    }
}
