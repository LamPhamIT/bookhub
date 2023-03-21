package com.shinn.model;

import lombok.*;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String country;
    private boolean sex;
    private String phoneNumber;
    private long accountID;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private String createdBy;
    private String modifiedBy;

    public Customer(String firstName, String lastName, String email, String city, String country, boolean sex, String phoneNumber, long accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
        this.country = country;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.accountID = accountID;
    }
}
