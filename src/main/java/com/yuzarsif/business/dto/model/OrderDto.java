package com.yuzarsif.business.dto.model;

import java.time.LocalDateTime;

public class OrderDto {

    private String id;
    private OrderCustomerDto customer;
    private ProductDto product;
    private LocalDateTime orderedTime;

    public OrderDto() {}

    public OrderDto(String id, OrderCustomerDto customer, ProductDto product, LocalDateTime orderedTime) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.orderedTime = orderedTime;
    }

    public String getId() {
        return id;
    }

    public OrderCustomerDto getCustomer() {
        return customer;
    }

    public ProductDto getProduct() {
        return product;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }
}
