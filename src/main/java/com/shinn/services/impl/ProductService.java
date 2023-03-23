package com.shinn.services.impl;

import com.shinn.dao.idao.IProductDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.Product;
import com.shinn.services.iservice.IProductService;


import java.sql.Timestamp;
import java.util.List;

public class ProductService implements IProductService {

    private IProductDAO productDAO;
    public ProductService() {
        productDAO = new ProductDAO();
    }
    @Override
    public Product save(Product product) {
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setCreatedBy("");
        Long productID = productDAO.insert(product);
        return productDAO.findOne(productID);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
