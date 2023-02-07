package com.yuzarsif.business.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Company extends User {

    private String companyName;
    private String webSite;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();
    @OneToMany(mappedBy = "company", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>();

    public Company() {}

    public Company(String email, String password, boolean isActive, String companyName, String webSite, Set<Address> addresses, Set<PhoneNumber> phoneNumbers, Set<Product> products) {
        super(email, password, isActive);
        this.companyName = companyName;
        this.webSite = webSite;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
        this.products = products;
    }

    public Company(String id, String email, String password, boolean isActive, String companyName, String webSite, Set<Address> addresses, Set<PhoneNumber> phoneNumbers, Set<Product> products) {
        super(id, email, password, isActive);
        this.companyName = companyName;
        this.webSite = webSite;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
        this.products = products;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebSite() {
        return webSite;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
