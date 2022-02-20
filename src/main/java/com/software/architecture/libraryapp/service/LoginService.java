package com.software.architecture.libraryapp.service;

import com.software.architecture.libraryapp.model.authentication.AuthenticationRequest;
import com.software.architecture.libraryapp.model.authentication.AuthenticationResponse;
import com.software.architecture.libraryapp.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public LoginService(AuthenticationManager authenticationManager, UserService userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    public Optional<AuthenticationResponse> generateToken(AuthenticationRequest request) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            return Optional.empty();
        }

        UserDetails userDetails = userService.loadUserByUsername(request.getEmail());
        String jwt = jwtUtil.generateToken(userDetails);
        return Optional.of(new AuthenticationResponse(jwt));
    }
}
