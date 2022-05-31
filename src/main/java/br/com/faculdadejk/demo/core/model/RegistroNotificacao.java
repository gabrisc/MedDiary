package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroNotificacaoEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "RegistroNotificacao",schema = "TCC")
public class RegistroNotificacao extends Registro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroNotificacao;

    @Column(nullable = false)
    private String resposta;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private CategoriaRegistroNotificacaoEnum categoriaRegistroNotificacaoEnum;

}
