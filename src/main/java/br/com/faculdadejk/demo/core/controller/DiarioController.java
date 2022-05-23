package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.model.dto.DiarioDTO;
import br.com.faculdadejk.demo.core.model.dto.DiarioResponseDTO;
import br.com.faculdadejk.demo.core.services.DiarioService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@RequestMapping(name = "/diary")
@RequiredArgsConstructor
public class DiarioController {

    @Autowired
    private DiarioService diarioService;
    private final ModelMapper modelMapper;

    @PostMapping("/create")
    @ApiOperation(value = "")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public DiarioResponseDTO createDiario(HttpServletRequest request) {
        return diarioService.novoDiario(request);
    }

    @GetMapping(value = "/findDiario")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public DiarioDTO findDiario(HttpServletRequest request) {
        return modelMapper.map(diarioService.findByIdUsuario(request),DiarioDTO.class);
    }

    @DeleteMapping(value = "/deleteDiario/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public void delete(HttpServletRequest request) {
        diarioService.deleteDiario(request);
    }
}
