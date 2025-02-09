package com.sport.Projet_GYM.repository;

import com.sport.Projet_GYM.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    // Méthodes spécifiques si besoin
}
