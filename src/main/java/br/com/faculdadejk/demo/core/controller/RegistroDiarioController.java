package br.com.faculdadejk.demo.core.controller;

import br.com.faculdadejk.demo.core.services.RegistroDiarioService;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/msg")
@RequiredArgsConstructor
public class RegistroDiarioController {

    @Autowired
    private RegistroDiarioService registroDiarioService;

//    @PostMapping("/create")
//    @ApiOperation(value = "")
//    @ApiResponses(value = {//
//            @ApiResponse(code = 400, message = "Something went wrong"), //
//            @ApiResponse(code = 403, message = "Access denied"), //
//            @ApiResponse(code = 404, message = "The user doesn't exist"), //
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public String create() {
//
//        return null;
//    }
//
//    @GetMapping(value = "/read")
//    @PreAuthorize("hasRole('ROLE_PATIENT')")
//    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
//    @ApiResponses(value = {//
//            @ApiResponse(code = 400, message = "Something went wrong"), //
//            @ApiResponse(code = 403, message = "Access denied"), //
//            @ApiResponse(code = 404, message = "The user doesn't exist"), //
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public String read() {
//        return "algo";
//    }
//    @GetMapping(value = "/read/{id}")
//    @PreAuthorize("hasRole('ROLE_PATIENT')")
//    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
//    @ApiResponses(value = {//
//            @ApiResponse(code = 400, message = "Something went wrong"), //
//            @ApiResponse(code = 403, message = "Access denied"), //
//            @ApiResponse(code = 404, message = "The user doesn't exist"), //
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public String read_fidID() {
//        return "algo";
//    }
//
//    @PutMapping(value = "/update/{id}")
//    @PreAuthorize("hasRole('ROLE_PATIENT')")
//    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
//    @ApiResponses(value = {//
//            @ApiResponse(code = 400, message = "Something went wrong"), //
//            @ApiResponse(code = 403, message = "Access denied"), //
//            @ApiResponse(code = 404, message = "The user doesn't exist"), //
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public String update() {
//        return "algo";
//    }
//
//    @DeleteMapping(value = "/delete/{id}")
//    @PreAuthorize("hasRole('ROLE_PATIENT')")
//    @ApiOperation(value = "", authorizations = { @Authorization(value="apiKey") })
//    @ApiResponses(value = {//
//            @ApiResponse(code = 400, message = "Something went wrong"), //
//            @ApiResponse(code = 403, message = "Access denied"), //
//            @ApiResponse(code = 404, message = "The user doesn't exist"), //
//            @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
//    public String delete() {
//        return "algo";
//
//    }
}
