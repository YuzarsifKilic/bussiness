package com.yuzarsif.business.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Enumerated(EnumType.STRING)
    @Column(name = "category_type")
    private CategoryType categoryType;
    private String subCategory;
    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Product> product;

    public Category() {}

    public Category(int id, CategoryType categoryType, String subCategory, Set<Product> product) {
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

    public Set<Product> getProduct() {
        return product;
    }
}
