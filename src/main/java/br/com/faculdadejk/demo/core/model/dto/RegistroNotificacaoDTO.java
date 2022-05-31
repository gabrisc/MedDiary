package br.com.faculdadejk.demo.core.model.dto;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroNotificacaoEnum;
import br.com.faculdadejk.demo.core.model.Registro;
import io.swagger.annotations.ApiModelProperty;

public class RegistroNotificacaoDTO extends Registro {

    @ApiModelProperty(position = 0)
    private String resposta;

    @ApiModelProperty(position = 1)
    private CategoriaRegistroNotificacaoEnum categoriaRegistroNotificacaoEnum;

    @ApiModelProperty(position = 3)
    private Registro registro;

}
