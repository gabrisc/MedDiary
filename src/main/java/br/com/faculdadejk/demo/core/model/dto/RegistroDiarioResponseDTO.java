package br.com.faculdadejk.demo.core.model.dto;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroEnum;
import br.com.faculdadejk.demo.core.enums.TipoRegistroEnum;
import br.com.faculdadejk.demo.core.model.Diario;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RegistroDiarioResponseDTO {

    @ApiModelProperty(position = 0)
    private String conteudoRegistro;

    @ApiModelProperty(position = 1)
    private String resposta;

    @ApiModelProperty(position = 2)
    private LocalDateTime dataCriacao;

    @ApiModelProperty(position = 3)
    private LocalDateTime dataAlteracao;

    @ApiModelProperty(position = 4)
    private TipoRegistroEnum tipoRegistro;

    @ApiModelProperty(position = 5)
    private CategoriaRegistroEnum categoriaRegistro;

    @ApiModelProperty(position = 6)
    private DiarioResponseDTO idDiario;
}
