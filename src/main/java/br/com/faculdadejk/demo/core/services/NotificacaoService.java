package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Notificacao;
import br.com.faculdadejk.demo.core.repository.NotificacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private DiarioService diarioService;

    public Notificacao newNotificacao(Notificacao notificacao, HttpServletRequest request) {
        notificacao.setIdUsuario(diarioService.findByIdUsuario(request).getIdUsuario());
        notificacao.setDataCriacao(LocalDateTime.now());
        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> findAllNotificacoes(HttpServletRequest request) {
        return new ArrayList<>(notificacaoRepository.findAllByIdUsuarioId(
                diarioService.findByIdUsuario(request).getIdUsuario().getId()));
    }

    public Notificacao updateNotificacao(Notificacao notificacaoEncaminhado ) {
        Notificacao atividadeRecorrenteInBase = notificacaoRepository.findById(notificacaoEncaminhado.getIdAtividadeRecorrente()).orElseThrow(() -> new NotFoundException("não foi encontrado"));
        atividadeRecorrenteInBase.setMensagemDoAlerta(notificacaoEncaminhado.getMensagemDoAlerta());
        atividadeRecorrenteInBase.setRecorrenciaEnum(notificacaoEncaminhado.getRecorrenciaEnum());
        atividadeRecorrenteInBase.setDataCriacao(LocalDateTime.now());
        atividadeRecorrenteInBase.setDataFimValidade(notificacaoEncaminhado.getDataFimValidade());
        atividadeRecorrenteInBase.setHorarioEnum(notificacaoEncaminhado.getHorarioEnum());
        atividadeRecorrenteInBase.setDataInicioValidade(notificacaoEncaminhado.getDataInicioValidade());
        return notificacaoRepository.save(atividadeRecorrenteInBase);
    }

    public HttpStatus deleteNotificacao(Long idAtividadeRecorrente) {
        HttpStatus resposta;
        if (Objects.nonNull(idAtividadeRecorrente)) {
            notificacaoRepository.deleteById(idAtividadeRecorrente);
            resposta = HttpStatus.OK;
        } else {
            resposta = HttpStatus.NOT_FOUND;
        }
        return resposta;
    }

}
