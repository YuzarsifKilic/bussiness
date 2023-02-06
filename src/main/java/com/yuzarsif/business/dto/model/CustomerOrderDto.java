package com.yuzarsif.business.dto.model;

import java.time.LocalDateTime;

public class CustomerOrderDto {

    private String id;
    private ProductDto product;
    private LocalDateTime orderedTime;

    public CustomerOrderDto() {}

    public CustomerOrderDto(String id, ProductDto product, LocalDateTime orderedTime) {
        this.id = id;
        this.product = product;
        this.orderedTime = orderedTime;
    }

    public String getId() {
        return id;
    }

    public ProductDto getProduct() {
        return product;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }
}
