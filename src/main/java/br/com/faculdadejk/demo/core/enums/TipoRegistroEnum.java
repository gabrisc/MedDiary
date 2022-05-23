package br.com.faculdadejk.demo.core.enums;

import lombok.Getter;

@Getter
public enum TipoRegistroEnum {

    REGISTRO_DIARIO_PESSOAL(1),
    REGISTRO_DIARIO_ATIVIDADE_RECORRENTE(2);

    private Integer type;

    TipoRegistroEnum(Integer type) {
        this.type = type;
    }
}
