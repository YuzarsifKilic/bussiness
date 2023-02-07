package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {

    Optional<Customer> findById(String id);
}
