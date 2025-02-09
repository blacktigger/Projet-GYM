package com.sport.Projet_GYM.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // ✅ Lombok pour les Getters/Setters
@AllArgsConstructor  // ✅ Constructeur avec arguments
@NoArgsConstructor  // ✅ Constructeur sans argument (nécessaire pour Jackson)
public class AuthRequest {
    private String username;
    private String password;
}
