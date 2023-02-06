package com.yuzarsif.business.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer extends User {

    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Order> orders;

    public Customer() {}

    public Customer(String id, String email, String password, boolean isActive, String firstName, String lastName, Set<Address> addresses, Set<PhoneNumber> phoneNumbers, Set<Order> orders) {
        super(id, email, password, isActive);
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
        this.orders = orders;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}
