package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.ProductDtoConverter;
import com.yuzarsif.business.dto.model.ProductDto;
import com.yuzarsif.business.dto.request.CreateProductRequest;
import com.yuzarsif.business.exception.ProductNotFoundException;
import com.yuzarsif.business.model.Category;
import com.yuzarsif.business.model.Company;
import com.yuzarsif.business.model.Product;
import com.yuzarsif.business.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final CompanyService companyService;
    private final ProductDtoConverter converter;

    public ProductService(ProductRepository productRepository,
                          CategoryService categoryService,
                          CompanyService companyService, ProductDtoConverter converter) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.companyService = companyService;
        this.converter = converter;
    }

    public ProductDto createProduct(CreateProductRequest request) {
        Category category = categoryService.findById(request.getCategoryId());
        Company company = companyService.findByEmail(request.getCompanyEmail());
        Product product = new Product(request.getName(), request.getPrice(), false, category, company);
        return converter.convert(productRepository.save(product));
    }

    protected Product findById(String id) {
        return productRepository
                .findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("Could not find Product by id : " + id));
    }

    public List<ProductDto> getByProductId(int categoryId) {
        return productRepository
                .findAll()
                .stream()
                .filter(p -> p.getCategory().getId() == categoryId)
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
