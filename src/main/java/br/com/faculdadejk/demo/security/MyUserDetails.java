package br.com.faculdadejk.demo.security;

import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyUserDetails implements UserDetailsService {

  private final UsuarioRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Usuario appUser = userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User '" + username + "' not found"));

    return org.springframework.security.core.userdetails.User//
        .withUsername(username)//
        .password(appUser.getPassword())//
        .authorities(appUser.getUsuarioEnumRules())//
        .accountExpired(false)//
        .accountLocked(false)//
        .credentialsExpired(false)//
        .disabled(false)//
        .build();
  }

}
