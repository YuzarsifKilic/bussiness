package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
