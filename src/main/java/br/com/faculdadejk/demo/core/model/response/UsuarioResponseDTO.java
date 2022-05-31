package br.com.faculdadejk.demo.core.model.response;

import br.com.faculdadejk.demo.core.enums.UsuarioEnumRule;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class UsuarioResponseDTO {

    @ApiModelProperty(position = 0)
    private String nomeCompleto;

    @ApiModelProperty(position = 1)
    private String email;

    @ApiModelProperty(position = 2)
    private String cpf_CRM;

    @ApiModelProperty(position = 3)
    private String username;

    @ApiModelProperty(position = 4)
    List<UsuarioEnumRule> usuarioEnumRules;

    @ApiModelProperty(position = 5)
    private LocalDate dataCriacao;

}
