package com.shinn.api.web;

import com.shinn.model.Product;
import com.shinn.services.impl.ProductService;
import com.shinn.services.iservice.IProductService;
import com.shinn.utils.HttpUtil;
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
        response.setContentType("application/json");        // Báo cho client dữ liệu trả về là Json
        List< Product> list = productService.findAll();
        objectMapper.writeValue(response.getOutputStream(), list);     // Hiển thị dữ liệu Json
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Product product = HttpUtil.of(request.getReader()).toModel(Product.class);
        product = productService.save(product);
        objectMapper.writeValue(response.getOutputStream(), product);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Product product = HttpUtil.of(request.getReader()).toModel(Product.class);
        productService.delete(product);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        Product product = HttpUtil.of(request.getReader()).toModel(Product.class);
        productService.update(product);
    }
}
