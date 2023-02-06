package com.yuzarsif.business.dto.model;

public class ProductDto {

    private String id;
    private String name;
    private double price;
    private boolean isSold;
    private ProductCategoryDto category;
    private ProductCompanyDto company;

    public ProductDto(String id, String name, double price, boolean isSold, ProductCategoryDto category, ProductCompanyDto company) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isSold = isSold;
        this.category = category;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    public ProductCategoryDto getCategory() {
        return category;
    }

    public ProductCompanyDto getCompany() {
        return company;
    }
}
