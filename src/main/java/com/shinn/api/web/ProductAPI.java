package com.shinn.api.web;

import com.shinn.model.Product;
import com.shinn.services.impl.ProductService;
import com.shinn.services.iservice.IProductService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.codehaus.jackson.map.ObjectMapper;
import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/api-products"})
public class ProductAPI extends HttpServlet {

    private IProductService productService;
    public ProductAPI() {
        productService = new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List< Product> list = productService.findAll();
        objectMapper.writeValue(response.getOutputStream(), list);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
