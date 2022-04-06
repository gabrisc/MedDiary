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
@Table(name = "PACIENTE_MEDICO_RELAC",schema = "TCC")
public class PacienteMedicoRelac {

    @Id
    @Column(name = "ID_PACIENTE_MEDICO_RELAC")
    @SequenceGenerator(name = "SEQ_PACIENTE_MEDICO_RELAC", schema = "TCC",sequenceName = "SQ_PACIENTE_MEDICO_RELAC",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_PACIENTE_MEDICO_RELAC")
    private Long idMedicoPaciente;

    @Column(name = "ID_MEDICO_RELAC")
    private Long IdMedico;

    @Column(name = "ID_PACIENTE_RELAC")
    private Date IdPaciente;

}
