package com.software.architecture.libraryapp.controller;

import com.software.architecture.libraryapp.model.authentication.AuthenticationRequest;
import com.software.architecture.libraryapp.model.authentication.AuthenticationResponse;
import com.software.architecture.libraryapp.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) {

        Optional<AuthenticationResponse> authenticationResponse = loginService.generateToken(authenticationRequest);

        if (authenticationResponse.isPresent()) {
            return ResponseEntity.ok(authenticationResponse.get());
        }
        return ResponseEntity.badRequest().build();
    }
}
