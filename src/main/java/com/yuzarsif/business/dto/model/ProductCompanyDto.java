package com.yuzarsif.business.dto.model;

import java.util.HashSet;
import java.util.Set;

public class ProductCompanyDto {

    private String id;
    private String email;
    private String companyName;
    private String webSite;
    private Set<AddressDto> addresses = new HashSet<>();
    private Set<PhoneNumberDto> phoneNumbers = new HashSet<>();

    public ProductCompanyDto() {}

    public ProductCompanyDto(String id, String email, String companyName, String webSite, Set<AddressDto> addresses, Set<PhoneNumberDto> phoneNumbers) {
        this.id = id;
        this.email = email;
        this.companyName = companyName;
        this.webSite = webSite;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
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
}
