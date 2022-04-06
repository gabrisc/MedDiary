package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.CategoriaMensagemEnum;
import br.com.faculdadejk.demo.core.enums.TipoMensagemEnum;
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
@Table(name = "MENSAGEM",schema = "TCC")
public class Mensagem {

    @Id
    @Column(name = "ID_MENSAGEM")
    @SequenceGenerator(name = "SEQ_MENSAGEM", schema = "TCC",sequenceName = "SQ_MENSAGEM",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_MENSAGEM")
    private Long idMensagem;

    @Column(name = "ID_DIARIO")
    private Long idDiario;

    @Column(name = "CONTEUDO_MENSAGEM")
    private Long conteudoMensagem;

    @Column(name = "DATA_CRIACAO")
    private Date dataCriacao;

    @Column(name = "TIPO_MENSAGEM")
    private Long tipoMensagem;

    @Column(name = "CATEGORIA_MENSAGEM")
    private Long categoriaMensagem;
}
