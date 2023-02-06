package com.yuzarsif.business.model;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "category_type")
    private CategoryType categoryType;
    private String subCategory;
    @OneToOne(mappedBy = "category")
    private Product product;

    public Category() {}

    public Category(int id, CategoryType categoryType, String subCategory, Product product) {
        this.id = id;
        this.categoryType = categoryType;
        this.subCategory = subCategory;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public Product getProduct() {
        return product;
    }
}
