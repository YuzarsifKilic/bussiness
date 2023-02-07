package com.yuzarsif.business.dto.request;

public class CreateOrderRequest {

    private String customerEmail;
    private String productId;

    public CreateOrderRequest() {}

    public CreateOrderRequest(String customerEmail, String productId) {
        this.customerEmail = customerEmail;
        this.productId = productId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getProductId() {
        return productId;
    }
}
