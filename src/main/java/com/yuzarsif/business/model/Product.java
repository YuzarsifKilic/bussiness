package com.yuzarsif.business.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;
    private String name;
    private double price;
    private boolean isSold;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id", nullable = false)
    private Company company;
    @OneToOne(mappedBy = "product")
    private Order order;

    public Product() {}

    public Product(String name, double price, boolean isSold, Category category, Company company) {
        this.name = name;
        this.price = price;
        this.isSold = isSold;
        this.category = category;
        this.company = company;
    }

    public Product(String id, String name, double price, boolean isSold, Category category, Company company, Order order) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isSold = isSold;
        this.category = category;
        this.company = company;
        this.order = order;
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

    public Category getCategory() {
        return category;
    }

    public Company getCompany() {
        return company;
    }

    public Order getOrder() {
        return order;
    }
}
