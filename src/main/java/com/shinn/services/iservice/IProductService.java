package com.shinn.services.iservice;

import com.shinn.model.Product;

import java.util.List;

public interface IProductService {
    public Product save(Product product);
    public List<Product> findAll();
    public void delete(Product product);
    public void update(Product product);
}
