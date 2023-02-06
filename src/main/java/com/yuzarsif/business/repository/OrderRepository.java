package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
