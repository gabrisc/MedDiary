package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.CategoriaRegistroPessoalEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "RegistroPessoal",schema = "TCC")
public class RegistroPessoal extends Registro  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegistroPessoal;

    @Column
    @Enumerated(EnumType.ORDINAL)
    private CategoriaRegistroPessoalEnum categoriaRegistroPessoalEnum;


}
