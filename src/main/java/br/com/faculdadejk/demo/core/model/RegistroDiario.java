package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroEnum;
import br.com.faculdadejk.demo.core.enums.TipoRegistroEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
@Data
@Entity
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistro;

    @Column(nullable = false)
    private String conteudoRegistro;

    @Column(nullable = false)
    private String resposta;

    @Column
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAlteracao;

    @ElementCollection(fetch = FetchType.EAGER)
    private TipoRegistroEnum tipoRegistro;

    @ElementCollection(fetch = FetchType.EAGER)
    private CategoriaRegistroEnum categoriaRegistro;

    @ManyToOne
    @JoinColumn(name="diario_id", referencedColumnName = "idDiario", nullable = false)
    private Diario idDiario;
}
