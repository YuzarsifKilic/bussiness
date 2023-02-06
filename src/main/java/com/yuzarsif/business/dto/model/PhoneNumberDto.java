package com.yuzarsif.business.dto.model;

import com.yuzarsif.business.model.PhoneNumberType;

public class PhoneNumberDto {

    private Long id;
    private String phoneNumber;
    private PhoneNumberType phoneNumberType;

    public PhoneNumberDto() {}

    public PhoneNumberDto(Long id, String phoneNumber, PhoneNumberType phoneNumberType) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }
}
