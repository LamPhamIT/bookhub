package com.shinn.api.web;

import com.shinn.services.impl.CustomerService;
import com.shinn.services.iservice.ICustomerService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.inject.Inject;
import java.io.IOException;

@WebServlet(urlPatterns = {"/api-customers"})
public class CustomerAPI extends HttpServlet {
    @Inject
    private ICustomerService customerService;

    public CustomerAPI() {
        customerService = new CustomerService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
