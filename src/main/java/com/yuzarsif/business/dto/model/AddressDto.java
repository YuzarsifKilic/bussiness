package com.yuzarsif.business.dto.model;

public class AddressDto {

    private Long id;
    private String apartmentNo;
    private String flat;
    private String street;
    private String province;
    private String district;
    private String country;

    public AddressDto() {}

    public AddressDto(Long id, String apartmentNo, String flat, String street, String province, String district, String country) {
        this.id = id;
        this.apartmentNo = apartmentNo;
        this.flat = flat;
        this.street = street;
        this.province = province;
        this.district = district;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public String getFlat() {
        return flat;
    }

    public String getStreet() {
        return street;
    }

    public String getProvince() {
        return province;
    }

    public String getDistrict() {
        return district;
    }

    public String getCountry() {
        return country;
    }
}
