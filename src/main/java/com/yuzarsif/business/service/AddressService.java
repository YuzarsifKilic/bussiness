package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.AddressDtoConverter;
import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.dto.request.CreateAddressRequest;
import com.yuzarsif.business.model.Address;
import com.yuzarsif.business.model.User;
import com.yuzarsif.business.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserService userService;
    private final AddressDtoConverter converter;

    public AddressService(AddressRepository addressRepository, UserService userService, AddressDtoConverter converter) {
        this.addressRepository = addressRepository;
        this.userService = userService;
        this.converter = converter;
    }

    public List<AddressDto> getAll() {
        return addressRepository
                .findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }

    public AddressDto createAddress(CreateAddressRequest request) {
        User user = userService.findByEmail(request.getEmail());
        Address address = new Address(
                request.getApartmentNo(),
                request.getFlat(),
                request.getStreet(),
                request.getProvince(),
                request.getDistrict(),
                request.getCountry(),
                user);

        return converter.convert(addressRepository.save(address));
    }
}
