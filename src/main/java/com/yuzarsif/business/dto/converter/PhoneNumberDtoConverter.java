package com.yuzarsif.business.dto.converter;

import com.yuzarsif.business.dto.model.PhoneNumberDto;
import com.yuzarsif.business.model.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PhoneNumberDtoConverter {

    public PhoneNumberDto convert(PhoneNumber from) {
        return new PhoneNumberDto(from.getId(), from.getPhoneNumber(), from.getPhoneNumberType());
    }

    public Set<PhoneNumberDto> convert(Set<PhoneNumber> from) {
        return from.stream().map(this::convert).collect(Collectors.toSet());
    }
}
