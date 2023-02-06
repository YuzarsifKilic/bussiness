package com.yuzarsif.business.dto.model;

import java.util.HashSet;
import java.util.Set;

public class CustomerDto {

    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<AddressDto> addresses = new HashSet<>();
    private Set<PhoneNumberDto> phoneNumbers = new HashSet<>();
    private Set<CustomerOrderDto> orders = new HashSet<>();

    public CustomerDto() {}

    public CustomerDto(String id, String email, String firstName, String lastName, Set<AddressDto> addresses, Set<PhoneNumberDto> phoneNumbers, Set<CustomerOrderDto> customers) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
        this.orders = orders;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
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

    public Set<CustomerOrderDto> getOrders() {
        return orders;
    }
}
