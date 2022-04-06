package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.PacienteMedicoRelac;
import br.com.faculdadejk.demo.core.repository.PacienteMedicoRelacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.Objects;

public class PacienteMedicoRelacService {

    @Autowired
    private PacienteMedicoRelacRepository pacienteMedicoRelacRepository;

    public PacienteMedicoRelac novaPacienteMedicoRelac(PacienteMedicoRelac novaRelacao) {
        return pacienteMedicoRelacRepository.save(novaRelacao);
    }

    public PacienteMedicoRelac atualizarPacienteMedicoRelac(PacienteMedicoRelac pacienteMedicoRelac) {
        if (pacienteMedicoRelacRepository.existsById(pacienteMedicoRelac.getIdMedicoPaciente())){
            return pacienteMedicoRelacRepository.save(pacienteMedicoRelac);
        } else {
            throw new NotFoundException("Não foi possivel encontrar a mensagem");
        }
    }

    public HttpStatus ApagarPacienteMedicoRelac(Long idPacienteMedicoRelac) {
        if (Objects.nonNull(idPacienteMedicoRelac)) {
            pacienteMedicoRelacRepository.deleteById(idPacienteMedicoRelac);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public PacienteMedicoRelac findPacienteMedicoRelacById(Long id) {
        return pacienteMedicoRelacRepository.findById(id).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar a mensagem"));
    };

}
