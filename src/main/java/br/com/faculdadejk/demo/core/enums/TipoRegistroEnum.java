package br.com.faculdadejk.demo.core.enums;

import lombok.Getter;

@Getter
public enum TipoRegistroEnum {

    MENSAGENS_PRIVADAS(1),
    MENSAGENS_PUBLICAS(2),
    MENSAGEM_FORUM(3);

    private Integer type;

    TipoRegistroEnum(Integer type) {
        this.type = type;
    }
}
