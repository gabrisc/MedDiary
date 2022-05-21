package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Diario;
import br.com.faculdadejk.demo.core.repository.DiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DiarioService {

    @Autowired
    private DiarioRepository diarioRepository;

    public Diario novoDiario(Diario diario) {
        return diarioRepository.save(diario);
    }

    public Diario atualizarDiario(Diario diario) {
        if (diarioRepository.existsById(diario.getIdDiario())){
            return diarioRepository.save(diario);
        } else {
            throw new NotFoundException("Não foi possivel encontrar o diario");
        }
    }

    public HttpStatus ApagarDiario(Long idDiario) {
        if (Objects.nonNull(idDiario)) {
            diarioRepository.deleteById(idDiario);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

    public Diario findDiarioByIdDiario(Long idDiario) {
        return diarioRepository.findById(idDiario).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar o diario"));
    };

    public Diario findDiarioByIdUsuario(Long idPaciente) {
        return diarioRepository.findByIdUsuario(idPaciente).orElseThrow(() -> new NotFoundException("Não foi possivel encontrar o diario"));
    };

}
