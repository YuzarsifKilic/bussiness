package com.yuzarsif.business.dto.request;

public class CreateCustomerRequest {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public CreateCustomerRequest() {}

    public CreateCustomerRequest(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
