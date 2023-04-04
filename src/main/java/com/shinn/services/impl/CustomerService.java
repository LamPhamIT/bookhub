package com.shinn.services.impl;

import com.shinn.dao.idao.ICustomerDAO;
import com.shinn.dao.impl.CustomerDAO;
import com.shinn.model.Customer;
import com.shinn.services.iservice.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerDAO customerDAO;
    public CustomerService() {
        customerDAO = new CustomerDAO();
    }
    @Override
    public List<Customer> findAll() {
        return null;
    }
}
