package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.RegistroDiario;
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

    public RegistroDiario novaMensagem(RegistroDiario novaRegistroDiario) {
        novaRegistroDiario.setDataCriacao(new Date());
        return mensagemRepository.save(novaRegistroDiario);
    }

    public RegistroDiario atualizarMensagem(RegistroDiario registroDiarioAlterada) {
        if (mensagemRepository.existsById(registroDiarioAlterada.getIdMensagem())){
            return mensagemRepository.save(registroDiarioAlterada);
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

    public RegistroDiario findMensagemByIdDiario(Long id) {
        return mensagemRepository.findMensagemByIdDiario(id).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar a mensagem"));
    };

}
