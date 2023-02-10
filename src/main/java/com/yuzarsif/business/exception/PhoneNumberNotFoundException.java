package com.yuzarsif.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PhoneNumberNotFoundException extends RuntimeException {

    public PhoneNumberNotFoundException(String message) {
        super(message);
    }
}
