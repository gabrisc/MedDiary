package br.com.faculdadejk.demo.core.model;

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
public class Endereco {

    @Id
    @Column(name = "ID_ENDERECO")
    @SequenceGenerator(name = "SEQ_ENDERECO", schema = "TCC",sequenceName = "SQ_ENDERECO",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ENDERECO")
    private Long idEndereco;

    @OneToOne(mappedBy = "enderecoUsuario")
    private Usuario usuario;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "NUMERO")
    private Integer numero;

    @Column(name = "COMPLEMENTO")
    private String complemento;
}
