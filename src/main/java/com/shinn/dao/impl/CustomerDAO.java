package com.shinn.dao.impl;

import com.shinn.dao.idao.ICustomerDAO;
import com.shinn.model.Customer;

public class CustomerDAO extends AbstractDAO<Customer> implements ICustomerDAO {
    @Override
    public Long insert(Customer customer) {
        String sql = "INSERT INTO Customer VALUES(?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, customer.getFirstName(), customer.getLastName());

    }
}
