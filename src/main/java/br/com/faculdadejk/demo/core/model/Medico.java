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
@Table(name = "MEDICO",schema = "TCC")
public class Medico {

    @Id
    @Column(name = "ID_MEDICO")
    @SequenceGenerator(name = "SEQ_MEDICO", schema = "TCC",sequenceName = "SQ_MEDICO",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_MEDICO")
    private Long idMedico;

    @NotNull
    @Column(name = "CRM")
    private String crm;

    @NotNull
    @Column(name = "ID_MEDICO_USUARIO")
    private Long idMedicoUsuario;
}
