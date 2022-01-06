package com.software.architecture.libraryapp.model.authentication;

public class AuthenticationResponse {

    private final String token;

    public AuthenticationResponse(String jwt) {
        this.token = jwt;
    }

    public String getToken() {
        return token;
    }
}
