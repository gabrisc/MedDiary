package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.RegistroDiario;
import br.com.faculdadejk.demo.core.repository.RegistroDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class RegistroDiarioService {

    @Autowired
    private RegistroDiarioRepository registroDiarioRepository;

    public RegistroDiario novaMensagem(RegistroDiario novaRegistroDiario) {
        novaRegistroDiario.setDataCriacao(LocalDateTime.now());
        return registroDiarioRepository.save(novaRegistroDiario);
    }

    public RegistroDiario atualizarMensagem(RegistroDiario registroDiarioAlterada) {
        if (registroDiarioRepository.existsById(registroDiarioAlterada.getIdRegistro())){
            return registroDiarioRepository.save(registroDiarioAlterada);
        } else {
            throw new NotFoundException("Não foi possivel encontrar a mensagem");
        }
    }

    public HttpStatus ApagarMensagem(Long idMensagem) {
        if (Objects.nonNull(idMensagem)) {
            registroDiarioRepository.deleteById(idMensagem);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public RegistroDiario findRegistroDiarioByIdDiario(Long id) {
        return registroDiarioRepository.findRegistroDiarioByIdDiario(id).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar a mensagem"));
    };

}
