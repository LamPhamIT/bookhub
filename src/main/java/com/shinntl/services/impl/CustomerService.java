package com.shinntl.services.impl;

import com.shinntl.dao.idao.ICustomerDAO;
import com.shinntl.dao.impl.CustomerDAO;
import com.shinntl.model.Customer;
import com.shinntl.services.iservice.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
//    @Inject
//    private ICustomerDAO customerDAO;   // Fix
    private ICustomerDAO customerDAO;
    public CustomerService() {
        customerDAO = new CustomerDAO();
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }
}
