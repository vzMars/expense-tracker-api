package dev.marcosgonzalez.expensetracker.controller;

import dev.marcosgonzalez.expensetracker.dto.AuthResponse;
import dev.marcosgonzalez.expensetracker.dto.LoginBody;
import dev.marcosgonzalez.expensetracker.dto.SignupBody;
import dev.marcosgonzalez.expensetracker.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping()
    public AuthResponse authStatus(Authentication authentication) {
        return authService.authStatus(authentication);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody @Valid LoginBody body, HttpServletRequest req, HttpServletResponse res) {
        return authService.login(body, req, res);
    }

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody @Valid SignupBody body, HttpServletRequest req, HttpServletResponse res) {
        return authService.signup(body, req, res);
    }
}
