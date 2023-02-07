package com.yuzarsif.business.dto.request;

public class CreateProductRequest {

    private String companyEmail;
    private String name;
    private double price;
    private int categoryId;

    public CreateProductRequest() {}

    public CreateProductRequest(String companyEmail, String name, double price, int categoryId) {
        this.companyEmail = companyEmail;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
