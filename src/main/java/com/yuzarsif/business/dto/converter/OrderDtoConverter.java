package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.OrderDto;
import com.yuzarsif.business.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDtoConverter {

    private final OrderCustomerDtoConverter orderCustomerDtoConverter;
    private final ProductDtoConverter categoryProductDtoConverter;

    public OrderDtoConverter(OrderCustomerDtoConverter orderCustomerDtoConverter, ProductDtoConverter categoryProductDtoConverter) {
        this.orderCustomerDtoConverter = orderCustomerDtoConverter;
        this.categoryProductDtoConverter = categoryProductDtoConverter;
    }

    public OrderDto convert(Order from) {
        return new OrderDto(
                from.getId(),
                orderCustomerDtoConverter.convert(from.getCustomer()),
                categoryProductDtoConverter.convert(from.getProduct()),
                from.getOrderedTime());
    }

    public List<OrderDto> convert(List<Order> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
