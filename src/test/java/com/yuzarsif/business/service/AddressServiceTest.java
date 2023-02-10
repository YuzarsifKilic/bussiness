package com.yuzarsif.business.service;

import com.yuzarsif.business.TestSupport;
import com.yuzarsif.business.dto.converter.AddressDtoConverter;
import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.dto.request.CreateAddressRequest;
import com.yuzarsif.business.exception.AddressNotFoundException;
import com.yuzarsif.business.model.Address;
import com.yuzarsif.business.model.User;
import com.yuzarsif.business.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

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
    public void testCreateAddress_whenUserIdExists_shouldCreateAddress() {
        CreateAddressRequest request = generateCreateAddressRequest();

        User user = generateUser();
        Address address = generateAddress();
        AddressDto addressDto = new AddressDto(1L, "-apartment-no", "-flat", "-street", "user-province", "-district", "-country");

        Mockito.when(userService.findById(request.getId())).thenReturn(user);
        Mockito.when(addressRepository.save(address)).thenReturn(address);
        Mockito.when(converter.convert(address)).thenReturn(addressDto);

        AddressDto result = addressService.createAddress(request);

        assertEquals(result, addressDto);
    }

    @Test
    public void testFindAddressById_whenAddressIdExists_shouldReturnAddress() {
        Address address = generateAddress();

        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(address));

        Address result = addressService.findById(1L);

        assertEquals(result, address);
    }

    @Test
    public void testFindAddressById_whenAddressIdDoesNotExists_shouldThrowAddressNotFoundException() {
        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(AddressNotFoundException.class, () -> addressService.findById(1L));
    }

    @Test
    public void testGetAddressById_whenAddressIdExists_shouldReturnAddressDto() {
        Address address = generateAddress();
        AddressDto addressDto = new AddressDto(1L, "-apartment-no", "-flat", "-street", "user-province", "-district", "-country");

        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.of(address));
        Mockito.when(converter.convert(address)).thenReturn(addressDto);

        AddressDto result = addressService.getById(1L);

        assertEquals(result, addressDto);
    }

    @Test
    public void testGetAddressById_whenAddressIdExists_shouldThrowAddressNotFoundException() {
        Mockito.when(addressRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(AddressNotFoundException.class, () -> addressService.getById(1L));

        Mockito.verifyNoInteractions(converter);
    }

}