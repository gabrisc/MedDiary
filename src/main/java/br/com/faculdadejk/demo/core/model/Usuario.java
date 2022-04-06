package br.com.faculdadejk.demo.core.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "USUARIO",schema = "TCC")
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", schema = "TCC",sequenceName = "SQ_USUARIO",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_USUARIO")
    private Long idUsuario;

    @NotNull
    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @NotNull
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

}
