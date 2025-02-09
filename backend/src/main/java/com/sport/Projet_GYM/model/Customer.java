package com.sport.Projet_GYM.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "registration_date", nullable = false)
    private LocalDate registrationDate;

    @Pattern(regexp = "^\\+?[0-9]+$", message = "Le numéro de téléphone doit être valide")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "active_subscription")
    @Builder.Default
    private Boolean activeSubscription = false;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Subscription> subscriptions = new ArrayList<>();

    // Méthodes utilitaires pour gérer la relation bidirectionnelle
    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
        subscription.setCustomer(this);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
        subscription.setCustomer(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return id != null && id.equals(customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
