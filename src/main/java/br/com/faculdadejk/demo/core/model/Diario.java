package br.com.faculdadejk.demo.core.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Diario",schema = "TCC")
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
