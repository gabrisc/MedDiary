package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.UsuarioEnumRule;
import lombok.*;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Diario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiario;

    @Column
    private LocalDate dataCriacao;

    @Column
    private LocalDate dataAlteracao;

    @ManyToOne
    @JoinColumn(name="usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario idUsuario;

}
