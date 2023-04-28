package com.shinntl.services.iservice;

import com.shinntl.model.Product;
import com.shinntl.paging.Pageble;

import java.util.List;

public interface IProductService {
    public Product save(Product product);
    public List<Product> findAll(Pageble paging);
    public void delete(Product product);
    public void update(Product product);
    public Integer count();
    public Product findOne(Long id);
}
