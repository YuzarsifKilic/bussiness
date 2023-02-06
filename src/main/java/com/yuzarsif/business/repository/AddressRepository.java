package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
