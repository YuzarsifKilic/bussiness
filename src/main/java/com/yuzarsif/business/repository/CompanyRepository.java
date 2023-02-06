package com.yuzarsif.business.repository;

import com.yuzarsif.business.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, String> {
}
