package com.yuzarsif.business.model;

import jakarta.persistence.*;

@Entity
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "phone_number_type")
    private PhoneNumberType phoneNumberType;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public PhoneNumber() {}

    public PhoneNumber(String phoneNumber, PhoneNumberType phoneNumberType, User user) {
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
        this.user = user;
    }

    public PhoneNumber(Long id, String phoneNumber, PhoneNumberType phoneNumberType, User user) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberType getPhoneNumberType() {
        return phoneNumberType;
    }

    public User getUser() {
        return user;
    }
}
