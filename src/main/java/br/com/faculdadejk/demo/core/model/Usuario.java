package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.TipoUsuarioEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Usuario implements Serializable {

    @Id
    @Column(name = "ID_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", schema = "TCC",sequenceName = "SQ_USUARIO",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_USUARIO")
    private Long idUsuario;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "CPF")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "ENDERECO_ID")
    private Endereco enderecoUsuario;

    @Column(name = "USUARIO")
    private String usuario;

    @Column(name = "SENHA")
    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuarioEnum tipoUsuarioEnum;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

    @Column(name = "STATUS_USUARIO")
    private Boolean statusUsuario;

    @OneToOne
    @JoinColumn(name = "DIARIO_ID")
    private Diario diarioId;

    @OneToMany(mappedBy = "paciente")
    private List<MedicoPermitido> medicosPermitidos;

}
