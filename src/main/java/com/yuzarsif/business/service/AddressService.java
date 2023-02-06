package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.AddressDtoConverter;
import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressDtoConverter converter;

    public AddressService(AddressRepository addressRepository, AddressDtoConverter converter) {
        this.addressRepository = addressRepository;
        this.converter = converter;
    }

    public List<AddressDto> getAll() {
        return addressRepository
                .findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
