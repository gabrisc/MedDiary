package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Mensagem;
import br.com.faculdadejk.demo.core.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

@Service
public class MensagemService {

    @Autowired
    private MensagemRepository mensagemRepository;

    public Mensagem novaMensagem(Mensagem novaMensagem) {
        novaMensagem.setDataCriacao(new Date());
        return mensagemRepository.save(novaMensagem);
    }

    public Mensagem atualizarMensagem(Mensagem mensagemAlterada) {
        if (mensagemRepository.existsById(mensagemAlterada.getIdMensagem())){
            return mensagemRepository.save(mensagemAlterada);
        } else {
            throw new NotFoundException("Não foi possivel encontrar a mensagem");
        }
    }

    public HttpStatus ApagarMensagem(Long idMensagem) {
        if (Objects.nonNull(idMensagem)) {
            mensagemRepository.deleteById(idMensagem);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public Mensagem findMensagemByIdDiario(Long id) {
        return mensagemRepository.findMensagemByIdDiario(id).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar a mensagem"));
    };

}
