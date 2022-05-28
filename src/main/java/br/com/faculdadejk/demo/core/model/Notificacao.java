package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.TipoLembreteEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Notificacao",schema = "TCC")
public class Notificacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDiario;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private LocalTime horarioLembrete;

    @Column
    private LocalDate dataLembrete;

    @Column
    private TipoLembreteEnum tipoLembreteEnum;

    @Column
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAlteracao;

}
