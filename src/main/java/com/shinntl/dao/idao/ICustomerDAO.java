package com.shinntl.dao.idao;

import com.shinntl.model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();
    Long insert(Customer customer);
}
