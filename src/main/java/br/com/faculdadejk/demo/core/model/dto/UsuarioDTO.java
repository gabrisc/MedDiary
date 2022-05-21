package br.com.faculdadejk.demo.core.model.dto;

import br.com.faculdadejk.demo.core.enums.UsuarioEnumRule;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioDTO {

    @ApiModelProperty(position = 0)
    private String nomeCompleto;

    @ApiModelProperty(position = 1)
    private String email;

    @ApiModelProperty(position = 2)
    private String cpf_CRM;

    @ApiModelProperty(position = 3)
    private String username;

    @ApiModelProperty(position = 4)
    private String password;

    @ApiModelProperty(position = 5)
    List<UsuarioEnumRule> usuarioEnumRules;

}
