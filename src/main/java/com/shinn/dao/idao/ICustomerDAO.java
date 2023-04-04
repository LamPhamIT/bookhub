package com.shinn.dao.idao;

import com.shinn.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();
    Long insert(Customer customer);
}
