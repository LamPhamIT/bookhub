package com.shinn.dao.impl;

import com.shinn.dao.idao.ICustomerDAO;
import com.shinn.mapper.CustomerMapper;
import com.shinn.model.Customer;

import java.util.List;

public class CustomerDAO extends AbstractDAO<Customer> implements ICustomerDAO {
    @Override
    public Long insert(Customer customer) {
        String sql = "INSERT INTO Customer VALUES(?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, customer.getFirstName(), customer.getLastName());
    }

    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM Customer";
        return query(sql, new CustomerMapper());
    }
}
