package com.yuzarsif.business.dto.model;

import java.util.HashSet;
import java.util.Set;

public class OrderCustomerDto {

    private String id;
    private String email;
    private String firsName;
    private String lastName;
    private Set<AddressDto> addresses = new HashSet<>();
    private Set<PhoneNumberDto> phoneNumbers = new HashSet<>();

    public OrderCustomerDto() {}

    public OrderCustomerDto(String id, String email, String firsName, String lastName, Set<AddressDto> addresses, Set<PhoneNumberDto> phoneNumbers) {
        this.id = id;
        this.email = email;
        this.firsName = firsName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<AddressDto> getAddresses() {
        return addresses;
    }

    public Set<PhoneNumberDto> getPhoneNumbers() {
        return phoneNumbers;
    }
}
