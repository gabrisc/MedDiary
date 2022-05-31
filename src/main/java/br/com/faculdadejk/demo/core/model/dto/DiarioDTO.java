package br.com.faculdadejk.demo.core.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class DiarioDTO {

    @ApiModelProperty(position = 0)
    private LocalDateTime dataCriacao;

    @ApiModelProperty(position = 1)
    private LocalDateTime dataAlteracao;

    @ApiModelProperty(position = 2)
    private UsuarioDTO idUsuario;

}
