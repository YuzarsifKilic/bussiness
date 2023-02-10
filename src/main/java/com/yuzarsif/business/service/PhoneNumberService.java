package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.PhoneNumberDtoConverter;
import com.yuzarsif.business.dto.model.PhoneNumberDto;
import com.yuzarsif.business.dto.request.CreatePhoneNumberRequest;
import com.yuzarsif.business.exception.PhoneNumberNotFoundException;
import com.yuzarsif.business.model.PhoneNumber;
import com.yuzarsif.business.model.User;
import com.yuzarsif.business.repository.PhoneNumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;
    private final UserService userService;
    private final PhoneNumberDtoConverter converter;

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository, UserService userService, PhoneNumberDtoConverter converter) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.userService = userService;
        this.converter = converter;
    }

    public List<PhoneNumberDto> getAll() {
        return phoneNumberRepository
                .findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public PhoneNumberDto createPhoneNumber(CreatePhoneNumberRequest request) {
        User user = userService.findByEmail(request.getEmail());
        PhoneNumber phoneNumber = new PhoneNumber(request.getPhoneNumber(), request.getPhoneNumberType(), user);
        return converter.convert(phoneNumberRepository.save(phoneNumber));
    }

    protected PhoneNumber findById(Long id) {
        return phoneNumberRepository
                .findById(id)
                .orElseThrow(
                        () -> new PhoneNumberNotFoundException("Could not find PhoneNumber by id : " + id));
    }

    public PhoneNumberDto getById(Long id) {
        return converter.convert(findById(id));
    }
}
