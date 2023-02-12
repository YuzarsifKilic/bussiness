package com.yuzarsif.business;

import com.yuzarsif.business.dto.converter.AddressDtoConverter;
import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.dto.request.CreateAddressRequest;
import com.yuzarsif.business.model.Address;
import com.yuzarsif.business.model.PhoneNumber;
import com.yuzarsif.business.model.PhoneNumberType;
import com.yuzarsif.business.model.User;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TestSupport {

    public User generateUser() {
        return user;
    }

    private static final User user = new User("123456", "yuzarsifkilic@gmail.com", "yuzarsif", true);

    public Address generateAddress() {
        Address address = new Address(
                1L,
                "-apartment-no",
                "-flat",
                "-street",
                "user-province",
                "-district",
                "-country",
                user);
        return address;
    }

    public Address generateAddressWithoutId() {
        Address address = new Address(
                "-apartment-no",
                "-flat",
                "-street",
                "user-province",
                "-district",
                "-country",
                user);
        return address;
    }

    public PhoneNumber generatePhoneNumber() {
        PhoneNumber phoneNumber = new PhoneNumber(
                1L,
                "5532720929",
                PhoneNumberType.PhoneNumber,
                generateUser());
        return phoneNumber;
    }

    public CreateAddressRequest generateCreateAddressRequest() {
        CreateAddressRequest request = new CreateAddressRequest(
                "123456",
                "-apartment-no",
                "-flat",
                "-street",
                "user-province",
                "-district",
                "-country");
        return request;
    }

}
