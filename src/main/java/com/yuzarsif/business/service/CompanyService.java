package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.ProductCompanyDtoConverter;
import com.yuzarsif.business.dto.model.ProductCompanyDto;
import com.yuzarsif.business.dto.request.CreateCompanyRequest;
import com.yuzarsif.business.model.Company;
import com.yuzarsif.business.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ProductCompanyDtoConverter converter;

    public CompanyService(CompanyRepository companyRepository, ProductCompanyDtoConverter converter) {
        this.companyRepository = companyRepository;
        this.converter = converter;
    }

    public ProductCompanyDto createCompany(CreateCompanyRequest request) {
        Company company = new Company(
                request.getEmail(),
                request.getPassword(),
                false,
                request.getCompanyName(),
                request.getWebSite(),
                Set.of(),
                Set.of(),
                Set.of());

        return converter.convert(companyRepository.save(company));
    }
}
