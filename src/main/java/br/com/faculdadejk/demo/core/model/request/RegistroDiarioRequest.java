package br.com.faculdadejk.demo.core.model.request;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroEnum;
import br.com.faculdadejk.demo.core.enums.TipoRegistroEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistroDiarioRequest {

    @ApiModelProperty(position = 0)
    private String conteudoRegistro;

    @ApiModelProperty(position = 1)
    private String resposta;

    @ApiModelProperty(position = 2)
    private CategoriaRegistroEnum categoriaRegistro;

    @ApiModelProperty(position = 3)
    private Long idRegistro;
}
