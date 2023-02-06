package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.ProductDto;
import com.yuzarsif.business.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductDtoConverter {

    private final ProductCategoryDtoConverter productCategoryDtoConverter;
    private final ProductCompanyDtoConverter productCompanyDtoConverter;

    public ProductDtoConverter(ProductCategoryDtoConverter productCategoryDtoConverter,
                               ProductCompanyDtoConverter productCompanyDtoConverter) {
        this.productCategoryDtoConverter = productCategoryDtoConverter;
        this.productCompanyDtoConverter = productCompanyDtoConverter;
    }

    public ProductDto convert(Product from) {
        return new ProductDto(
                from.getId(),
                from.getName(),
                from.getPrice(),
                from.isSold(),
                productCategoryDtoConverter.convert(from.getCategory()),
                productCompanyDtoConverter.convert(from.getCompany()));
    }

    public Set<ProductDto> convert(Set<Product> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
