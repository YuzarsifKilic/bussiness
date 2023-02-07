package com.yuzarsif.business.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    private LocalDateTime orderedTime;

    public Order() {}

    public Order(Customer customer, Product product, LocalDateTime orderedTime) {
        this.customer = customer;
        this.product = product;
        this.orderedTime = orderedTime;
    }

    public Order(String id, Customer customer, Product product, LocalDateTime orderedTime) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.orderedTime = orderedTime;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }
}
