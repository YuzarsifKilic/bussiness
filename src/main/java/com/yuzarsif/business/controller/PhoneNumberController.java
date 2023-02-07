package com.yuzarsif.business.controller;

import com.yuzarsif.business.dto.model.PhoneNumberDto;
import com.yuzarsif.business.dto.request.CreatePhoneNumberRequest;
import com.yuzarsif.business.service.PhoneNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phone-number")
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @PostMapping("/save")
    public ResponseEntity<PhoneNumberDto> save(@RequestBody CreatePhoneNumberRequest request) {
        return ResponseEntity.ok(phoneNumberService.createPhoneNumber(request));
    }
}
