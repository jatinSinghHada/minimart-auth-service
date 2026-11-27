package com.minimart.auth_service.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minimart.auth_service.dto.RegisterRequestDTO;
import com.minimart.auth_service.dto.RequestResponseDTO;
import com.minimart.auth_service.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public RequestResponseDTO createUser(@RequestBody @Valid RegisterRequestDTO request) {
        return authService.register(request);
    }
}
