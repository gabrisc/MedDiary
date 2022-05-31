package br.com.faculdadejk.demo.core.model;

import br.com.faculdadejk.demo.core.enums.RecorrenciaEnum;
import br.com.faculdadejk.demo.core.enums.TipoLembreteEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Notificacao",schema = "TCC")
public class Notificacao {

    @Id
    private Long idAtividadeRecorrente;

    @ManyToOne
    @JoinColumn(name="usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario idUsuario;

    @Column
    private String mensagemDoAlerta;

    @ElementCollection(fetch = FetchType.EAGER)
    private RecorrenciaEnum recorrenciaEnum;

    @Column
    private Time horarioEnum;

    @Column
    private LocalDate dataInicioValidade;

    @Column
    private LocalDate dataFimValidade;

    @Column
    private LocalDateTime dataCriacao;

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
    private LocalDateTime dataAlteracao;
}
