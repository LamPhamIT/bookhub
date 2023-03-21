package com.shinn.model;

import lombok.*;

import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends AbstractModel{
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String country;
    private boolean sex;
    private String phoneNumber;
    private long accountID;


}
