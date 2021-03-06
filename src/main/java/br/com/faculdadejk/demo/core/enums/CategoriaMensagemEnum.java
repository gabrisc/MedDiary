package br.com.faculdadejk.demo.core.enums;

import lombok.Getter;

@Getter
public enum CategoriaMensagemEnum {

    AZUL_NADA_URGENTE(1),
    VERDE_POUCO_URGENTE(2),
    AMARELO_URGENTE(3),
    LARANJA_MUITO_URGENTE(4);

    private Integer type;

    CategoriaMensagemEnum(Integer type) {
        this.type = type;
    }
}
