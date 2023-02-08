package com.yuzarsif.business.controller;

import com.yuzarsif.business.dto.model.ProductCategoryDto;
import com.yuzarsif.business.model.Category;
import com.yuzarsif.business.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public ProductCategoryDto getById(@PathVariable int id) {
        return categoryService.getById(id);
    }
}
