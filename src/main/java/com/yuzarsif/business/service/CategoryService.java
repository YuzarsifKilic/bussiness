package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.ProductCategoryDtoConverter;
import com.yuzarsif.business.dto.model.ProductCategoryDto;
import com.yuzarsif.business.exception.CategoryNotFoundException;
import com.yuzarsif.business.model.Category;
import com.yuzarsif.business.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductCategoryDtoConverter converter;

    public CategoryService(CategoryRepository categoryRepository, ProductCategoryDtoConverter converter) {
        this.categoryRepository = categoryRepository;
        this.converter = converter;
    }

    protected Category findById(int id) {
        return categoryRepository
                .findById(id)
                .orElseThrow(
                        () -> new CategoryNotFoundException("Could not find Category by id : " + id));
    }


}
