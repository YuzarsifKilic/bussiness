package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.CompanyDto;
import com.yuzarsif.business.model.Company;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompanyDtoConverter {

    private final AddressDtoConverter addressDtoConverter;
    private final PhoneNumberDtoConverter phoneNumberDtoConverter;
    private final ProductDtoConverter productDtoConverter;

    public CompanyDtoConverter(AddressDtoConverter addressDtoConverter, PhoneNumberDtoConverter phoneNumberDtoConverter, ProductDtoConverter productDtoConverter) {
        this.addressDtoConverter = addressDtoConverter;
        this.phoneNumberDtoConverter = phoneNumberDtoConverter;
        this.productDtoConverter = productDtoConverter;
    }

    public CompanyDto convert(Company from) {
        return new CompanyDto(
                from.getId(),
                from.getEmail(),
                from.getCompanyName(),
                from.getWebSite(),
                addressDtoConverter.convert(from.getAddresses()),
                phoneNumberDtoConverter.convert(from.getPhoneNumbers()),
                productDtoConverter.convert(from.getProducts()));
    }

    public List<CompanyDto> convert(List<Company> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
