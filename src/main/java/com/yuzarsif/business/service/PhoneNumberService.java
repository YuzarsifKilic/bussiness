package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.PhoneNumberDtoConverter;
import com.yuzarsif.business.dto.model.PhoneNumberDto;
import com.yuzarsif.business.repository.PhoneNumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;
    private final PhoneNumberDtoConverter converter;

    public PhoneNumberService(PhoneNumberRepository phoneNumberRepository, PhoneNumberDtoConverter converter) {
        this.phoneNumberRepository = phoneNumberRepository;
        this.converter = converter;
    }

    public List<PhoneNumberDto> getAll() {
        return phoneNumberRepository
                .findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
