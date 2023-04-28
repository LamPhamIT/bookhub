package com.shinntl.services.iservice;

import com.shinntl.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
