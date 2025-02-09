package com.sport.Projet_GYM;

import com.sport.Projet_GYM.model.Role;
import com.sport.Projet_GYM.model.User;
import com.sport.Projet_GYM.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                String hashedPassword = passwordEncoder.encode("admin"); // ✅ Hachage sécurisé

                User admin = User.builder()
                        .username("admin")
                        .password(hashedPassword)  // ✅ Stocker le mot de passe haché
                        .role(Role.ADMIN)
                        .build();

                userRepository.save(admin);
                System.out.println("✅ Utilisateur admin créé avec mot de passe sécurisé !");
            }
        };
    }
}
