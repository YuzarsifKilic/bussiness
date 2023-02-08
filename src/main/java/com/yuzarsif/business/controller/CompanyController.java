package com.yuzarsif.business.controller;

import com.yuzarsif.business.dto.model.CompanyDto;
import com.yuzarsif.business.dto.model.ProductCompanyDto;
import com.yuzarsif.business.dto.request.CreateCompanyRequest;
import com.yuzarsif.business.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProductCompanyDto> save(@RequestBody CreateCompanyRequest request) {
        return ResponseEntity.ok(companyService.createCompany(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CompanyDto>> getAll() {
        return ResponseEntity.ok(companyService.getAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<CompanyDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(companyService.getByEmail(email));
    }
}
