package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
