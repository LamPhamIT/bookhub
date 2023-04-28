package com.shinntl.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends AbstractModel<Customer>{
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String country;
    private boolean sex;
    private String phoneNumber;
    private long accountId;
}
