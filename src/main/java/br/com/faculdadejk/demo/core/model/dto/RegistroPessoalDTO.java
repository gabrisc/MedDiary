package br.com.faculdadejk.demo.core.model.dto;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroPessoalEnum;
import br.com.faculdadejk.demo.core.model.Registro;
import io.swagger.annotations.ApiModelProperty;

public class RegistroPessoalDTO {

    @ApiModelProperty(position = 0)
    private CategoriaRegistroPessoalEnum categoriaRegistroPessoalEnum;

    @ApiModelProperty(position = 1)
    private Registro registro;
}
