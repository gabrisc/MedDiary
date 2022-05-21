package br.com.faculdadejk.demo.core.model.dto;

import br.com.faculdadejk.demo.core.model.Usuario;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
public class DiarioDTO {

    @ApiModelProperty(position = 0)
    private LocalDate dataCriacao;

    @ApiModelProperty(position = 1)
    private LocalDate dataAlteracao;

    @ApiModelProperty(position = 2)
    private Usuario idUsuario;
}
