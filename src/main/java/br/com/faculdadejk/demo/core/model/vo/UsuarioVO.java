package br.com.faculdadejk.demo.core.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioVO {

    private Long idUsuario;
    private String nomeCompleto;
    private String username;
    private String password;
    private Date dataCriacao;

}
