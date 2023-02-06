package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
