package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Medico;
import br.com.faculdadejk.demo.core.repository.MedicoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MedicoService {

    private MedicoRepository medicoRepository;

    public Medico novoMedico(Medico pacienteNovo) {
        return medicoRepository.save(pacienteNovo);
    }

    public Medico atualizarMedico(Medico pacienteAlterado) {
        if (medicoRepository.existsById(pacienteAlterado.getIdMedico())){
            return medicoRepository.save(pacienteAlterado);
        } else {
            throw new NotFoundException("Não foi possivel encontrar o medico");
        }
    }

    public HttpStatus ApagarMedico(Long pacienteId) {
        if (Objects.nonNull(pacienteId)) {
            medicoRepository.deleteById(pacienteId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public Medico findMedicoById(Long id) {
        return medicoRepository.findById(id).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar o medico"));
    };
}
