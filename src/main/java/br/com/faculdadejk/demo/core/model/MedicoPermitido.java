package br.com.faculdadejk.demo.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class MedicoPermitido {

    @Id
    @Column(name = "ID_MEDICO_PERMITIDO")
    @SequenceGenerator(name = "SEQ_MEDICO_PERMITIDO", schema = "TCC",sequenceName = "SQ_MEDICO_PERMITIDO",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_MEDICO_PERMITIDO")
    private Long idMedicoPermitido;

    @ManyToOne
    @JoinColumn(name = "PACIENTE_ID")
    private Usuario paciente;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

}
