//package br.com.faculdadejk.demo.core.controller;
//
//import br.com.faculdadejk.demo.core.model.request.RegistroDiarioRequest;
//import br.com.faculdadejk.demo.core.model.response.RegistroDiarioResponseDTO;
//import br.com.faculdadejk.demo.core.services.RegistroDiarioService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@RestController
//@RequestMapping(name = "/msg")
//@RequiredArgsConstructor
//public class RegistroDiarioController {
//
//    @Autowired
//    private RegistroDiarioService registroDiarioService;
//
//    @PostMapping("/create-diary-personal")
//    @ApiOperation(value = "")
//    @ApiResponses(value = {//
//            @ApiResponse(code = 400, message = "Something went wrong"), //
//            @ApiResponse(code = 403, message = "Access denied"), //
//            @ApiResponse(code = 404, message = "The user doesn't exist"), //
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public RegistroDiarioResponseDTO createDiaryPersonal(@RequestBody RegistroDiarioRequest registroDiarioRequest, HttpServletRequest request) {
//        return registroDiarioService.novoRegistroDiarioPessoal(registroDiarioRequest, request);
//    }
//
//    @PostMapping("/create-diary-recurrent")
//    @ApiOperation(value = "")
//    @ApiResponses(value = {//
//            @ApiResponse(code = 400, message = "Something went wrong"), //
//            @ApiResponse(code = 403, message = "Access denied"), //
//            @ApiResponse(code = 404, message = "The user doesn't exist"), //
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public RegistroDiarioResponseDTO createDiaryRecurrent(@RequestBody RegistroDiarioRequest registroDiarioRequest, HttpServletRequest request) {
//        return registroDiarioService.novoRegistroDiarioAtividadeRecorrente(registroDiarioRequest, request);
//    }
//
//    @GetMapping("/findAllRegistroByIdDiario")
//    @ApiOperation(value = "")
//    @ApiResponses(value = {
//            @ApiResponse(code = 400, message = "Something went wrong"),
//            @ApiResponse(code = 403, message = "Access denied"),
//            @ApiResponse(code = 404, message = "The user doesn't exist"),
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public List<RegistroDiarioResponseDTO> findAllRegistroByIdDiario(HttpServletRequest request) {
//        return registroDiarioService.findAllRegistrosByIdDiario(request);
//    }
//
//    @GetMapping("/atualizarRegistroDiario")
//    @ApiOperation(value = "")
//    @ApiResponses(value = {
//            @ApiResponse(code = 400, message = "Something went wrong"),
//            @ApiResponse(code = 403, message = "Access denied"),
//            @ApiResponse(code = 404, message = "The user doesn't exist"),
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public RegistroDiarioResponseDTO atualizarRegistroDiario(@RequestBody RegistroDiarioResponseDTO registroDiarioResponseDTO) {
//        return registroDiarioService.atualizarRegistroDiario(registroDiarioResponseDTO);
//    }
//
//
//    @DeleteMapping(value = "/delete/{id}")
//    @ApiOperation(value = "")
//    @ApiResponses(value = {
//            @ApiResponse(code = 400, message = "Something went wrong"),
//            @ApiResponse(code = 403, message = "Access denied"),
//            @ApiResponse(code = 404, message = "The user doesn't exist"),
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public HttpStatus delete(@Param("id") Long id) {
//        return registroDiarioService.ApagarMensagem(id);
//    }
//}
