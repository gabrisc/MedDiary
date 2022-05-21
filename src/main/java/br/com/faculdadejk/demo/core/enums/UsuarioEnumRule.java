package br.com.faculdadejk.demo.core.enums;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum UsuarioEnumRule implements GrantedAuthority {
    ROLE_PATIENT, ROLE_MEDICT;

    @Override
    public String getAuthority() {
        return name();
    }
}
