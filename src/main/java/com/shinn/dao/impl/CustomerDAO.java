package com.shinn.dao.impl;

import com.shinn.dao.idao.ICustomerDAO;
import com.shinn.model.Customer;

public class CustomerDAO extends AbstractDAO<Customer> implements ICustomerDAO {
    @Override
    public boolean insert(Customer customer) {
        String sql = "INSERT INTO Customer VALUES(?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return update(sql, customer.getFirstName(), customer.getLastName());

    }
}
