package com.sport.Projet_GYM.repository;

import com.sport.Projet_GYM.model.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, Long> {
    // Méthodes spécifiques si nécessaire
}
