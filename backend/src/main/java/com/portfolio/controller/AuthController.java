package com.portfolio.controller;

import com.portfolio.repository.AdminUserRepository;
import com.portfolio.security.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    public record Login(String username, String password) {
    }

    public record Token(String token) {
    }

    private final AdminUserRepository users;
    private final PasswordEncoder encoder;
    private final JwtService jwt;

    public AuthController(
            AdminUserRepository users,
            PasswordEncoder encoder,
            JwtService jwt) {

        this.users = users;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login in) {

        var user = users.findByUsername(in.username());

        if (user.isEmpty()) {
            return ResponseEntity
                    .status(401)
                    .body(Map.of("error", "Invalid credentials"));
        }

        if (!encoder.matches(
                in.password(),
                user.get().getPassword())) {

            return ResponseEntity
                    .status(401)
                    .body(Map.of("error", "Invalid credentials"));
        }

        String token = jwt.generate(
                user.get().getUsername()
        );

        return ResponseEntity.ok(
                new Token(token)
        );
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(
            @RequestBody Token in) {

        try {
            String username = jwt.username(in.token());

            String newToken = jwt.generate(username);

            return ResponseEntity.ok(
                    new Token(newToken)
            );

        } catch (Exception e) {

            return ResponseEntity
                    .status(401)
                    .body(Map.of("error", "Invalid token"));
        }
    }
}