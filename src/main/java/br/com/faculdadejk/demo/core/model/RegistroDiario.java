package br.com.faculdadejk.demo.core.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class RegistroDiario {

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
