package com.shinn.controller.Admin;

import com.shinn.constant.SystemConstant;
import com.shinn.model.Product;
import com.shinn.services.impl.ProductService;
import com.shinn.services.iservice.IProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-products"})
public class ProductController extends HttpServlet {
    private IProductService productService;
    public ProductController() {
        productService = new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setListResult(productService.findAll());
        request.setAttribute(SystemConstant.MODEL, product);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/ListProduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
