package br.com.faculdadejk.demo.core.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "PACIENTE",schema = "TCC")
public class Paciente {

    @Id
    @Column(name = "ID_PACIENTE")
    @SequenceGenerator(name = "SEQ_PACIENTE", schema = "TCC",sequenceName = "SQ_PACIENTE",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_PACIENTE")
    private Long idPaciente;

    @NotNull
    @Column(name = "CPF")
    private String cpf;

    @NotNull
    @Column(name = "ID_USUARIO_PACIENTE")
    private Long idUsuarioPaciente;
}
