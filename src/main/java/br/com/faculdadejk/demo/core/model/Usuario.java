package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.UsuarioEnumRule;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Usuario",schema = "TCC")
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String nomeDeUsuario;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(unique = true, nullable = false)
    private String documento;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<UsuarioEnumRule> usuarioEnumRules;

    @Column
    private LocalDateTime dataCriacao;
}
