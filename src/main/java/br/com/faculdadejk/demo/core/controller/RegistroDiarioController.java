package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.model.dto.RegistroDiarioResponseDTO;
import br.com.faculdadejk.demo.core.model.request.RegistroDiarioRequest;
import br.com.faculdadejk.demo.core.services.RegistroDiarioService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(name = "/msg")
@RequiredArgsConstructor
public class RegistroDiarioController {

    @Autowired
    private RegistroDiarioService registroDiarioService;

    @PostMapping("/create-diary-personal")
    @ApiOperation(value = "")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public RegistroDiarioResponseDTO createDiaryPersonal(@RequestBody RegistroDiarioRequest registroDiarioRequest, HttpServletRequest request) {
        return registroDiarioService.novoRegistroDiarioPessoal(registroDiarioRequest, request);
    }

    @PostMapping("/create-diary-recurrent")
    @ApiOperation(value = "")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public RegistroDiarioResponseDTO createDiaryRecurrent(@RequestBody RegistroDiarioRequest registroDiarioRequest, HttpServletRequest request) {
        return registroDiarioService.novoRegistroDiarioAtividadeRecorrente(registroDiarioRequest, request);
    }

/*
    @GetMapping(value = "/read")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String read() {
        return "algo";
    }
    @GetMapping(value = "/read/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String read_fidID() {
        return "algo";
    }

    @PutMapping(value = "/update/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String update() {
        return "algo";
    }

    @DeleteMapping(value = "/delete/{id}")
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 404, message = "The user doesn't exist"), //
            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
    public String delete() {
        return "algo";

    }

 */
}
