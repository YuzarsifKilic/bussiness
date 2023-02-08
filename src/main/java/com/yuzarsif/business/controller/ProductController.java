package com.yuzarsif.business.controller;

import com.yuzarsif.business.dto.model.ProductDto;
import com.yuzarsif.business.dto.request.CreateProductRequest;
import com.yuzarsif.business.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ProductDto>> getAll() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable int categoryId) {
        return ResponseEntity.ok(productService.getByProductId(categoryId));
    }
}
