package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.model.Diario;
import br.com.faculdadejk.demo.core.model.Usuario;
import br.com.faculdadejk.demo.core.model.dto.DiarioDTO;
import br.com.faculdadejk.demo.core.model.dto.DiarioResponseDTO;
import br.com.faculdadejk.demo.core.model.dto.UsuarioDTO;
import br.com.faculdadejk.demo.core.services.DiarioService;
import br.com.faculdadejk.demo.core.services.UsuarioService;
import io.swagger.annotations.*;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.time.LocalDate;

import static br.com.faculdadejk.demo.core.enums.UsuarioEnumRule.ROLE_PATIENT;

@RestController
@RequestMapping(name = "/diary")
@RequiredArgsConstructor
public class DiarioController {

    @Autowired
    private DiarioService diarioService;
    @Autowired
    private UsuarioService usuarioService;
    private final ModelMapper modelMapper;

    @PostMapping("/cadastro")
    @ApiOperation(value = "Cadastro Diario - Efetura a função de cadastro de diario, esse função deverá ser inicida" +
                          "assim que o usuario for criado", authorizations = { @Authorization(value="apiKey") })
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use")})
    public DiarioResponseDTO cadastrarDiary(HttpServletRequest request) {
        Usuario usuario = usuarioService.whoami(request);
        DiarioDTO diario = new DiarioDTO();
        diario.setDataCriacao(LocalDate.now());
        diario.setDataAlteracao(LocalDate.now());
        diario.setIdUsuario(usuario);
        return modelMapper.map(diarioService.novoDiario(modelMapper.map(diario, Diario.class)), DiarioResponseDTO.class);
    }

    @GetMapping("/")
    @ApiOperation(value = "Cadastro Diario - Efetura a função de cadastro de diarios")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Username is already in use")})
    public DiarioResponseDTO listarDiario(@ApiParam Long id) {
        return modelMapper.map(diarioService.findDiarioByIdDiario(id), DiarioResponseDTO.class);
    }

}
