package br.com.faculdadejk.demo.core.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.time.YearMonth;

@Data
public abstract class Registro {

    @ManyToOne
    @JoinColumn(name="diario_id", referencedColumnName = "idDiario", nullable = false)
    private Diario idDiario;

    @Column(nullable = false)
    private String conteudoRegistro;

    @Column
    private YearMonth anoMes;

    @Column
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAlteracao;

}
