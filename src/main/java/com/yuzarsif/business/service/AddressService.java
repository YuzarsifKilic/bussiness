package com.yuzarsif.business.service;

import com.yuzarsif.business.dto.converter.AddressDtoConverter;
import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.dto.request.CreateAddressRequest;
import com.yuzarsif.business.exception.AddressNotFoundException;
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
        return converter.convertToList(addressRepository.findAll());
    }

    public AddressDto createAddress(CreateAddressRequest request) {
        User user = userService.findById(request.getId());
        Address address = new Address(
                request.getApartmentNo(),
                request.getFlat(),
                request.getStreet(),
                request.getProvince(),
                request.getDistrict(),
                request.getCountry(),
                user);

        Address savedAddress = addressRepository.save(address);

        return converter.convert(savedAddress);
    }

    public Address findById(Long id) {
        return addressRepository
                .findById(id)
                .orElseThrow(
                        () -> new AddressNotFoundException("Could not find Address by id : " + id));

    }

    protected AddressDto getById(Long id) {
        return converter.convert(findById(id));
    }
}
