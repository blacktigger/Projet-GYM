package com.sport.Projet_GYM.controller;

import com.sport.Projet_GYM.dto.AuthRequest;
import com.sport.Projet_GYM.dto.AuthResponse;
import com.sport.Projet_GYM.security.JwtUtil;
import com.sport.Projet_GYM.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            System.out.println("Tentative de connexion avec username: " + authRequest.getUsername());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            // Charge l'utilisateur depuis la base et génère le token
            final var userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());
            final var token = jwtUtil.generateToken(userDetails);

            System.out.println("Connexion réussie pour " + authRequest.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));

        } catch (AuthenticationException e) {
            System.out.println("Échec de l'authentification : Identifiants invalides !");
            return ResponseEntity.status(401).body("Identifiants invalides");
        }
    }
}
