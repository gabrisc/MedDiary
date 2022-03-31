package br.com.faculdadejk.demo.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Diario {

    @Id
    @Column(name = "ID_DIARIO")
    @SequenceGenerator(name = "SEQ_DIARIO", schema = "TCC",sequenceName = "SQ_DIARIO",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_DIARIO")
    private Long idDiario;

    @OneToMany(mappedBy = "diarioPaciente")
    private List<Mensagem> mensagens;

    @OneToOne(mappedBy = "diarioId")
    private Usuario usuarioDono;

}
