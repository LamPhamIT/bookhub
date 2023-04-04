package com.shinn.services.iservice;

import com.shinn.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
