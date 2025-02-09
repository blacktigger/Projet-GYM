package com.sport.Projet_GYM.repository;

import com.sport.Projet_GYM.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastNameContaining(String lastName);
}
