package com.yuzarsif.business.dto.model;

import java.util.HashSet;
import java.util.Set;

public class CompanyDto {

    private String id;
    private String email;
    private String companyName;
    private String webSite;
    private Set<AddressDto> addresses = new HashSet<>();
    private Set<PhoneNumberDto> phoneNumbers = new HashSet<>();
    private Set<ProductDto> products = new HashSet<>();

    public CompanyDto() {}

    public CompanyDto(String id, String email, String companyName, String webSite, Set<AddressDto> addresses, Set<PhoneNumberDto> phoneNumbers, Set<ProductDto> products) {
        this.id = id;
        this.email = email;
        this.companyName = companyName;
        this.webSite = webSite;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getWebSite() {
        return webSite;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public Set<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Set<ProductDto> getProducts() {
        return products;
    }
}
