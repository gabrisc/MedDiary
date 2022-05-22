package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroEnum;
import br.com.faculdadejk.demo.core.enums.TipoRegistroEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
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
    private List<TipoRegistroEnum> tipoRegistro;

    @ManyToOne
    @JoinColumn(name="diario_id", referencedColumnName = "idDiario", nullable = false)
    private Diario idDiario;
}
