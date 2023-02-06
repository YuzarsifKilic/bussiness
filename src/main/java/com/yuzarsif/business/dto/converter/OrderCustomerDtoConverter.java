package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.OrderCustomerDto;
import com.yuzarsif.business.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderCustomerDtoConverter {

    private final AddressDtoConverter addressDtoConverter;
    private final PhoneNumberDtoConverter phoneNumberDtoConverter;

    public OrderCustomerDtoConverter(AddressDtoConverter addressDtoConverter, PhoneNumberDtoConverter phoneNumberDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
        this.phoneNumberDtoConverter = phoneNumberDtoConverter;
    }

    public OrderCustomerDto convert(Customer from) {
        return new OrderCustomerDto(
                from.getId(),
                from.getEmail(),
                from.getFirstName(),
                from.getLastName(),
                addressDtoConverter.convert(from.getAddresses()),
                phoneNumberDtoConverter.convert(from.getPhoneNumbers()));
    }

    public List<OrderCustomerDto> convert(List<Customer> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
