package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroEnum;
import br.com.faculdadejk.demo.core.enums.TipoRegistroEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "RegistroDiario",schema = "TCC")
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

    @Column
    @Enumerated(EnumType.ORDINAL)
    private TipoRegistroEnum tipoRegistro;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private CategoriaRegistroEnum categoriaRegistro;

    @ManyToOne
    @JoinColumn(name="diario_id", referencedColumnName = "idDiario", nullable = false)
    private Diario idDiario;
}
