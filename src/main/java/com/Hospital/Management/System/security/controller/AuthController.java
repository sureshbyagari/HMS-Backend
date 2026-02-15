package com.Hospital.Management.System.security.controller;

import com.Hospital.Management.System.security.dto.LoginRequest;
import com.Hospital.Management.System.security.dto.LoginResponse;
import com.Hospital.Management.System.security.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}