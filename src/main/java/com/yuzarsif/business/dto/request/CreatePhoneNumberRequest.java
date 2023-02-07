package com.yuzarsif.business.dto.request;

import com.yuzarsif.business.model.PhoneNumberType;

public class CreatePhoneNumberRequest {

    private String email;
    private String phoneNumber;
    private PhoneNumberType phoneNumberType;

    public CreatePhoneNumberRequest() {}

    public CreatePhoneNumberRequest(String email, String phoneNumber, PhoneNumberType phoneNumberType) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }
}
