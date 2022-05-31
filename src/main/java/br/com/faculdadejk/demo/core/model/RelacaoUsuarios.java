package br.com.faculdadejk.demo.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "RelacaoUsuarios",schema = "TCC")
public class RelacaoUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelacaoUsuarios;

    @Column(nullable = false)
    private Long idUsuarioLiberador;

    @Column(nullable = false)
    private Long idUsuarioLiberado;

    @Column
    private LocalDateTime dataCriacao;

}
