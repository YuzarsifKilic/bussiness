package com.yuzarsif.business.service;

import com.yuzarsif.business.TestSupport;
import com.yuzarsif.business.dto.converter.AddressDtoConverter;
import com.yuzarsif.business.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class AddressServiceTest extends TestSupport {

    private AddressRepository addressRepository;
    private UserService userService;
    private AddressDtoConverter converter;

    private AddressService addressService;

    @BeforeEach
    public void setUp() {
        addressRepository = Mockito.mock(AddressRepository.class);
        userService = Mockito.mock(UserService.class);
        converter = Mockito.mock(AddressDtoConverter.class);

        addressService = new AddressService(addressRepository, userService, converter);
    }

    @Test
    public void testGetAllAddressDto() {
        Mockito.when(addressRepository.findAll()).thenReturn(generateAddressList());


    }

}