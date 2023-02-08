package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.CompanyDtoConverter;
import com.yuzarsif.business.dto.converter.ProductCompanyDtoConverter;
import com.yuzarsif.business.dto.model.CompanyDto;
import com.yuzarsif.business.dto.model.ProductCompanyDto;
import com.yuzarsif.business.dto.request.CreateCompanyRequest;
import com.yuzarsif.business.exception.CompanyNotFoundException;
import com.yuzarsif.business.model.Company;
import com.yuzarsif.business.model.User;
import com.yuzarsif.business.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final UserService userService;
    private final CompanyDtoConverter companyDtoConverter;
    private final ProductCompanyDtoConverter converter;

    public CompanyService(CompanyRepository companyRepository,
                          UserService userService,
                          CompanyDtoConverter companyDtoConverter,
                          ProductCompanyDtoConverter converter) {
        this.companyRepository = companyRepository;
        this.userService = userService;
        this.companyDtoConverter = companyDtoConverter;
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

    protected Company findByEmail(String email) {
        User user = userService.findByEmail(email);
        return companyRepository
                .findById(user.getId())
                .orElseThrow(
                        () -> new CompanyNotFoundException("Could not find Customer by email : " + email));
    }

    public List<CompanyDto> getAll() {
        return companyDtoConverter.convert(companyRepository.findAll());
    }

    public CompanyDto getByEmail(String email) {
        return companyDtoConverter.convert(findByEmail(email));
    }
}
