package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.CustomerOrderDto;
import com.yuzarsif.business.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerOrderDtoConverter {

    private final ProductDtoConverter productDtoConverter;

    public CustomerOrderDtoConverter(ProductDtoConverter productDtoConverter) {
        this.productDtoConverter = productDtoConverter;
    }

    public CustomerOrderDto convert(Order from) {
        return new CustomerOrderDto(from.getId(), productDtoConverter.convert(from.getProduct()), from.getOrderedTime());
    }

    public Set<CustomerOrderDto> convert(Set<Order> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
