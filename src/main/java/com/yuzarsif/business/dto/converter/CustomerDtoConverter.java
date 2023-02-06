package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.CustomerDto;
import com.yuzarsif.business.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoConverter {

    private final AddressDtoConverter addressDtoConverter;
    private final PhoneNumberDtoConverter phoneNumberDtoConverter;
    private final CustomerOrderDtoConverter customerOrderDtoConverter;

    public CustomerDtoConverter(AddressDtoConverter addressDtoConverter,
                                PhoneNumberDtoConverter phoneNumberDtoConverter,
                                CustomerOrderDtoConverter customerOrderDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
        this.phoneNumberDtoConverter = phoneNumberDtoConverter;
        this.customerOrderDtoConverter = customerOrderDtoConverter;
    }

    public CustomerDto convert(Customer from) {
        return new CustomerDto(
                from.getId(),
                from.getEmail(),
                from.getFirstName(),
                from.getLastName(),
                addressDtoConverter.convert(from.getAddresses()),
                phoneNumberDtoConverter.convert(from.getPhoneNumbers()),
                customerOrderDtoConverter.convert(from.getOrders()));
    }
}
