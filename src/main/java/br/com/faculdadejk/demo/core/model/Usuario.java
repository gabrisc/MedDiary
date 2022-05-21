package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.UsuarioEnumRule;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data // Create getters and setters
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @Column(unique = true, nullable = false)
    private String cpf_CRM;

    @ElementCollection(fetch = FetchType.EAGER)
    List<UsuarioEnumRule> usuarioEnumRules;

    @Column
    private LocalDate dataCriacao;

    @Column
    private LocalDate dataAlteracao;
}
