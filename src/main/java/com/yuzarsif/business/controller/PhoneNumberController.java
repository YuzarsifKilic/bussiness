package com.yuzarsif.business.controller;

import com.yuzarsif.business.dto.model.PhoneNumberDto;
import com.yuzarsif.business.dto.request.CreatePhoneNumberRequest;
import com.yuzarsif.business.service.PhoneNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getall")
    public ResponseEntity<List<PhoneNumberDto>> getAll() {
        return ResponseEntity.ok(phoneNumberService.getAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<PhoneNumberDto>> getPhoneNumberByUser(@PathVariable String id) {
        return ResponseEntity.ok(phoneNumberService.getByUser(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhoneNumberDto> getPhoneNumberById(@PathVariable Long id) {
        return ResponseEntity.ok(phoneNumberService.getById(id));
    }
}
