package com.sport.Projet_GYM.service;

import com.sport.Projet_GYM.model.User;
import com.sport.Projet_GYM.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("⭐ Tentative de chargement de l'utilisateur: " + username);

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    System.out.println("❌ Utilisateur non trouvé: " + username);
                    return new UsernameNotFoundException("User not found with username: " + username);
                });

        System.out.println("✅ Utilisateur trouvé: " + user.getUsername());
        System.out.println("✅ Rôle: " + user.getRole());
        System.out.println("✅ Password (haché): " + user.getPassword());

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );
    }
}