package com.yuzarsif.business.service;

import com.yuzarsif.business.TestSupport;
import com.yuzarsif.business.dto.converter.PhoneNumberDtoConverter;
import com.yuzarsif.business.dto.model.PhoneNumberDto;
import com.yuzarsif.business.exception.PhoneNumberNotFoundException;
import com.yuzarsif.business.model.PhoneNumber;
import com.yuzarsif.business.model.PhoneNumberType;
import com.yuzarsif.business.repository.PhoneNumberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberServiceTest extends TestSupport {

    private PhoneNumberRepository phoneNumberRepository;
    private UserService userService;
    private PhoneNumberDtoConverter converter;

    private PhoneNumberService phoneNumberService;

    @BeforeEach
    public void setUp() {
        phoneNumberRepository = Mockito.mock(PhoneNumberRepository.class);
        userService = Mockito.mock(UserService.class);
        converter = Mockito.mock(PhoneNumberDtoConverter.class);

        phoneNumberService = new PhoneNumberService(phoneNumberRepository, userService, converter);
    }

    @Test
    public void testFindPhoneNumberById_whenPhoneNumberIdExists_shouldReturnPhoneNumber() {
        PhoneNumber phoneNumber = generatePhoneNumber();

        Mockito.when(phoneNumberRepository.findById(1L)).thenReturn(Optional.of(phoneNumber));

        PhoneNumber result = phoneNumberService.findById(1L);

        assertEquals(result, phoneNumber);
    }

    @Test
    public void testFindPhoneNumberById_whenPhoneNumberIdDoesNotExists_shouldThrowPhoneNumberNotFoundException() {
        Mockito.when(phoneNumberRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PhoneNumberNotFoundException.class, () -> phoneNumberService.findById(1L));
    }

    @Test
    public void testGetPhoneNumberById_whenPhoneNumberIdExists_shouldReturnPhoneNumberDto() {
        PhoneNumber phoneNumber = generatePhoneNumber();
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto(1L, "5532720929", PhoneNumberType.PhoneNumber);

        Mockito.when(phoneNumberRepository.findById(1L)).thenReturn(Optional.of(phoneNumber));
        Mockito.when(converter.convert(phoneNumber)).thenReturn(phoneNumberDto);

        PhoneNumberDto result = phoneNumberService.getById(1L);

        assertEquals(result, phoneNumberDto);
    }

    @Test
    public void testGetPhoneNumberById_whenPhoneNumberIdExists_shouldThrowPhoneNumberNotFoundException() {
        Mockito.when(phoneNumberRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(PhoneNumberNotFoundException.class, () -> phoneNumberService.getById(1L));

        Mockito.verifyNoInteractions(converter);
    }

}