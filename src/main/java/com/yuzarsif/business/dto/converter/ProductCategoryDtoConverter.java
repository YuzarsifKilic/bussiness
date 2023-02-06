package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.ProductCategoryDto;
import com.yuzarsif.business.model.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryDtoConverter {

    public ProductCategoryDto convert(Category from) {
        return new ProductCategoryDto(from.getId(), from.getCategoryType(), from.getSubCategory());
    }
}
