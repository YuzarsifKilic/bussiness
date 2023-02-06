package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.ProductCompanyDto;
import com.yuzarsif.business.model.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductCompanyDtoConverter {

    private final PhoneNumberDtoConverter phoneNumberDtoConverter;
    private final AddressDtoConverter addressDtoConverter;

    public ProductCompanyDtoConverter(PhoneNumberDtoConverter phoneNumberDtoConverter, AddressDtoConverter addressDtoConverter) {
        this.phoneNumberDtoConverter = phoneNumberDtoConverter;
        this.addressDtoConverter = addressDtoConverter;
    }

    public ProductCompanyDto convert(Company from) {
        return new ProductCompanyDto(
                from.getId(),
                from.getEmail(),
                from.getCompanyName(),
                from.getWebSite(),
                addressDtoConverter.convert(from.getAddresses()),
                phoneNumberDtoConverter.convert(from.getPhoneNumbers()));
    }

    public List<ProductCompanyDto> convert(List<Company> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
