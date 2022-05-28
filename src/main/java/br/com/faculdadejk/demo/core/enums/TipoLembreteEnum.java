package br.com.faculdadejk.demo.core.enums;

import lombok.Getter;

@Getter
public enum TipoLembreteEnum {

    NAO_SE_REPETE(1),
    DIARIAMENTE(2),
    SEMANALMENTE(3),
    MENSAMENTE(4),
    ANUALMENTE(5);
    private Integer type;

    TipoLembreteEnum(Integer type){
        this.type=type;
    }

}
