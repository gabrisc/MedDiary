package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Paciente;
import br.com.faculdadejk.demo.core.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente novoPaciente(Paciente pacienteNovo) {
        return pacienteRepository.save(pacienteNovo);
    }

    public Paciente atualizarPaciente(Paciente pacienteAlterado) {
        if (pacienteRepository.existsById(pacienteAlterado.getIdPaciente())){
            return pacienteRepository.save(pacienteAlterado);
        } else {
            throw new NotFoundException("Não foi possivel encontrar o usuario");
        }
    }

    public HttpStatus ApagarPaciente(Long pacienteId) {
        if (Objects.nonNull(pacienteId)) {
            pacienteRepository.deleteById(pacienteId);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public Paciente findPacienteById(Long id) {
        return pacienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar o paciente"));
    };

}
