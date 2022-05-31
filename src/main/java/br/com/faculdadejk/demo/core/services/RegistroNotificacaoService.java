package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.model.Notificacao;
import br.com.faculdadejk.demo.core.model.RegistroNotificacao;
import br.com.faculdadejk.demo.core.repository.RegistroNotificacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroNotificacaoService {

    @Autowired
    private RegistroNotificacaoRepository registroNotificacaoRepository;
    @Autowired
    private DiarioService diarioService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private RegistroNotificacao registroNotificacao;

    public RegistroNotificacao newRegistroNotificacao(RegistroNotificacao registroNotificacao, HttpServletRequest request) {
        registroNotificacao.setAnoMes(YearMonth.now());
        registroNotificacao.setDataCriacao(LocalDateTime.now());
        registroNotificacao.setDataAlteracao(LocalDateTime.now());
        registroNotificacao.setIdDiario(diarioService.findByIdUsuario(request));

        return registroNotificacaoRepository.save(registroNotificacao);
    }

    public List<RegistroNotificacao> findAllRegistroNotificacaoByMonth(HttpServletRequest request, Month month) {
        return registroNotificacaoRepository.findAll();
    }

    public Notificacao updateRegistroNotificacao(Notificacao notificacaoEncaminhado ) {
        return null;
    }

    public HttpStatus deleteNotificacao(Long idAtividadeRecorrente) {
        return null;
    }

}
