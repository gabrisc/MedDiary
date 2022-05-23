package br.com.faculdadejk.demo.core.services;

import br.com.faculdadejk.demo.core.enums.TipoRegistroEnum;
import br.com.faculdadejk.demo.core.exception.NotFoundException;
import br.com.faculdadejk.demo.core.model.Diario;
import br.com.faculdadejk.demo.core.model.RegistroDiario;
import br.com.faculdadejk.demo.core.model.dto.RegistroDiarioResponseDTO;
import br.com.faculdadejk.demo.core.model.request.RegistroDiarioRequest;
import br.com.faculdadejk.demo.core.repository.RegistroDiarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistroDiarioService {

    @Autowired
    private RegistroDiarioRepository registroDiarioRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private DiarioService diarioService;

    public RegistroDiarioResponseDTO novoRegistroDiarioPessoal(RegistroDiarioRequest registroDiarioRequest, HttpServletRequest request) {
        RegistroDiario registroDiario = modelMapper.map(registroDiarioRequest,RegistroDiario.class);
        return createAndSaveRegistro(registroDiario,
                                     request,
                                     TipoRegistroEnum.REGISTRO_DIARIO_PESSOAL);
    }

    public RegistroDiarioResponseDTO novoRegistroDiarioAtividadeRecorrente(RegistroDiarioRequest registroDiarioRequest, HttpServletRequest request) {
        RegistroDiario registroDiario = modelMapper.map(registroDiarioRequest,RegistroDiario.class);
        return createAndSaveRegistro(registroDiario,
                                     request,
                                     TipoRegistroEnum.REGISTRO_DIARIO_ATIVIDADE_RECORRENTE);
    }

    private RegistroDiarioResponseDTO createAndSaveRegistro(RegistroDiario registroDiario, HttpServletRequest request, TipoRegistroEnum registroDiarioPessoal) {
        registroDiario.setIdDiario(diarioService.findByIdUsuario(request));
        registroDiario.setDataAlteracao(LocalDateTime.now());
        registroDiario.setDataCriacao(LocalDateTime.now());
        registroDiario.setTipoRegistro(registroDiarioPessoal);
        return modelMapper.map(registroDiarioRepository.save(registroDiario),RegistroDiarioResponseDTO.class);
    }

    public RegistroDiarioResponseDTO findAllRegistrosByIdDiario(HttpServletRequest request) {
        List<RegistroDiario> registros = registroDiarioRepository.findAllByIdDiario(diarioService.findByIdUsuario(request)
                                                                                                 .getIdDiario());

        return (RegistroDiarioResponseDTO) registros.stream().map(registroDiario -> modelMapper.map(registroDiario,
                                                                                                    RegistroDiarioResponseDTO.class))
                                                             .collect(Collectors.toList());
    }

    public RegistroDiarioResponseDTO atualizarRegistroDiario(RegistroDiarioResponseDTO registroDiarioResponseDTO, HttpServletRequest request) {
        RegistroDiario registroDiarioInBase = registroDiarioRepository.findById(registroDiarioResponseDTO.getIdRegistro())
                                                                      .orElseThrow(() -> new NotFoundException("não foi encontrado"));
        registroDiarioInBase.setConteudoRegistro(registroDiarioResponseDTO.getConteudoRegistro());
        registroDiarioInBase.setResposta(registroDiarioResponseDTO.getResposta());
        registroDiarioInBase.setCategoriaRegistro(registroDiarioResponseDTO.getCategoriaRegistro());
        registroDiarioInBase.setDataAlteracao(LocalDateTime.now());
        return modelMapper.map(registroDiarioRepository.save(registroDiarioInBase),RegistroDiarioResponseDTO.class);
    }

    public HttpStatus ApagarMensagem(Long idRegistro) {
        HttpStatus resposta;
        if (Objects.nonNull(idRegistro)) {
            registroDiarioRepository.deleteById(idRegistro);
            resposta = HttpStatus.OK;
        } else {
            resposta = HttpStatus.NOT_FOUND;
        }
        return resposta;
    }
}
