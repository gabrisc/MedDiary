package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.exception.CustomException;
import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Diario;
import br.com.faculdadejk.demo.core.model.dto.DiarioDTO;
import br.com.faculdadejk.demo.core.repository.DiarioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class DiarioService {

    @Autowired
    private DiarioRepository diarioRepository;
    @Autowired
    private UsuarioService usuarioService;

    private final ModelMapper modelMapper;

    public DiarioDTO newDiario(HttpServletRequest request) {
        Diario diario = new Diario();
        diario.setIdUsuario(usuarioService.whoami(request));
        diario.setDataCriacao(LocalDateTime.now());
        diario.setDataAlteracao(LocalDateTime.now());
        return modelMapper.map(diarioRepository.save(diario), DiarioDTO.class);
    }

    public Diario findByIdUsuario(HttpServletRequest request) {
        return diarioRepository.findByIdUsuario(usuarioService.whoami(request).getId())
                                        .orElseThrow(() -> new NotFoundException("não foi encontrado"));
    }

    public void deleteDiario(HttpServletRequest request) {
        try {
            Diario diario = diarioRepository.findByIdUsuario(usuarioService.whoami(request).getId())
                                            .orElseThrow(() -> new NotFoundException("não foi encontrado"));;
            diarioRepository.deleteById(diario.getIdDiario());
        } catch (Exception e) {
            throw new CustomException("Ocorreu um problema durante a operação",HttpStatus.BAD_REQUEST);
        }
    }
}
