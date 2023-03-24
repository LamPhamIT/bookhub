package com.shinn.dao.idao;

import com.shinn.model.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll();
    Long insert(Product product);
    Product findOne(Long productId);
    void deleteOne(Long productId);
    void update(Product product);
}
