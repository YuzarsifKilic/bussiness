package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.CompanyDto;
import com.yuzarsif.business.dto.model.ProductDto;
import com.yuzarsif.business.model.Company;
import com.yuzarsif.business.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
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
                new HashSet<>(productDtoConverter.convert(new ArrayList<>(from.getProducts()))));
    }

    public List<CompanyDto> convert(List<Company> from) {
        return from.stream().map(this::convert).collect(Collectors.toList());
    }
}
