package com.yuzarsif.business;

import com.yuzarsif.business.dto.converter.AddressDtoConverter;
import com.yuzarsif.business.dto.model.AddressDto;
import com.yuzarsif.business.model.Address;
import com.yuzarsif.business.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestSupport {

    public User generateUser() {
        User user = new User("123456", "yuzarsifkilic@gmail.com", "yuzarsif", true);
        return user;
    }

    public Address generateAddress(String userName) {
        Address address = new Address(1L,
                userName+ "-apartment-no",
                userName+ "-flat",
                userName+ "-street",
                userName+ "user-province",
                userName+ "-district",
                userName+ "-country",
                generateUser());
        return address;
    }

    public List<Address> generateAddressList() {
        Address address1 = generateAddress("1");
        Address address2 = generateAddress("2");
        Address address3 = generateAddress("3");

        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);

        return addressList;
    }

}
