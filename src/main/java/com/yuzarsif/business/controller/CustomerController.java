package com.yuzarsif.business.controller;

import com.yuzarsif.business.dto.model.CustomerDto;
import com.yuzarsif.business.dto.model.OrderCustomerDto;
import com.yuzarsif.business.dto.request.CreateCustomerRequest;
import com.yuzarsif.business.model.Customer;
import com.yuzarsif.business.model.User;
import com.yuzarsif.business.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<OrderCustomerDto> save(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<CustomerDto>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @GetMapping("/{email}")
    public ResponseEntity<CustomerDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(customerService.getByEmail(email));
    }
}
