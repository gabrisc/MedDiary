package br.com.faculdadejk.demo.core.model.dto;

import br.com.faculdadejk.demo.core.enums.UsuarioEnumRule;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class UsuarioDTO {

    @ApiModelProperty(position = 0)
    private String nome;

    @ApiModelProperty(position = 1)
    private String nomeDeUsuario;

    @ApiModelProperty(position = 2)
    private String email;

    @ApiModelProperty(position = 3)
    private String senha;

    @ApiModelProperty(position = 4)
    private String documento;

    @ApiModelProperty(position = 5)
    private List<UsuarioEnumRule> usuarioEnumRules;

    @ApiModelProperty(position = 6)
    private LocalDateTime dataCriacao;




}
