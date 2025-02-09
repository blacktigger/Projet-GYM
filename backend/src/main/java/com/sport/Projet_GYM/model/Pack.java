package com.sport.Projet_GYM.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pack")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pack implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "offer_name", nullable = false)
    private String offerName;

    @Column(name = "duration_months", nullable = false)
    private int durationMonths;

    @Column(name = "monthly_price", nullable = false)
    private BigDecimal monthlyPrice;

    @OneToMany(mappedBy = "pack", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Subscription> subscriptions = new ArrayList<>();

    // Méthodes utilitaires pour gérer la relation bidirectionnelle
    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
        subscription.setPack(this);
    }

    public void removeSubscription(Subscription subscription) {
        subscriptions.remove(subscription);
        subscription.setPack(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pack)) return false;
        Pack pack = (Pack) o;
        return id != null && id.equals(pack.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
