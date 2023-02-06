package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.model.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AddressDtoConverter {

    public AddressDto convert(Address from) {
        return new AddressDto(
                from.getId(),
                from.getApartmentNo(),
                from.getFlat(),
                from.getStreet(),
                from.getProvince(),
                from.getDistrict(),
                from.getCountry());
    }

    public Set<AddressDto> convert(Set<Address> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
