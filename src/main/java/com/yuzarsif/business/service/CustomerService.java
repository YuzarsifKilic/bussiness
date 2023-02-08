package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.CustomerDtoConverter;
import com.yuzarsif.business.dto.converter.OrderCustomerDtoConverter;
import com.yuzarsif.business.dto.model.CustomerDto;
import com.yuzarsif.business.dto.model.OrderCustomerDto;
import com.yuzarsif.business.dto.request.CreateCustomerRequest;
import com.yuzarsif.business.exception.CustomerNotFoundException;
import com.yuzarsif.business.model.Customer;
import com.yuzarsif.business.model.User;
import com.yuzarsif.business.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserService userService;
    private final CustomerDtoConverter customerDtoConverter;
    private final OrderCustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository,
                           UserService userService,
                           CustomerDtoConverter customerDtoConverter,
                           OrderCustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.userService = userService;
        this.customerDtoConverter = customerDtoConverter;
        this.converter = converter;
    }

    public OrderCustomerDto createCustomer(CreateCustomerRequest request) {
        Customer customer = new Customer(
                request.getEmail(),
                request.getPassword(),
                false,
                request.getFirstName(),
                request.getLastName(),
                Set.of(),
                Set.of(),
                Set.of());

        return converter.convert(customerRepository.save(customer));
    }

    protected Customer findById(String id) {
        return customerRepository
                .findById(id)
                .orElseThrow(
                        () -> new CustomerNotFoundException("Could not found Customer not found by id : " + id));
    }

    protected Customer findByEmail(String email) {
        User user = userService.findByEmail(email);
        Customer customer = findById(user.getId());
        return findById(user.getId());
    }


    public List<CustomerDto> getAll() {
        return customerDtoConverter.convert(customerRepository.findAll());
    }

    public CustomerDto getByEmail(String email) {
        return customerDtoConverter.convert(findByEmail(email));
    }
}
