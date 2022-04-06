package br.com.faculdadejk.demo.core.enums;

import lombok.Getter;

@Getter
public enum TipoMensagemEnum {

    MENSAGENS_PRIVADAS(1),
    MENSAGENS_PUBLICAS(2),
    MENSAGEM_FORUM(3);

    private Integer type;

    TipoMensagemEnum(Integer type) {
        this.type = type;
    }
}
