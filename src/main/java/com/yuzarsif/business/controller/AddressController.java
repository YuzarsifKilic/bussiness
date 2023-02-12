package com.yuzarsif.business.controller;

import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.dto.request.CreateAddressRequest;
import com.yuzarsif.business.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public ResponseEntity<AddressDto> save(@RequestBody CreateAddressRequest request) {
        return ResponseEntity.ok(addressService.createAddress(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<AddressDto>> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<AddressDto>> getAddressesByUser(@PathVariable String id) {
        return ResponseEntity.ok(addressService.getByUserId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.getById(id));
    }
}
