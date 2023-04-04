package com.shinn.services.iservice;

import com.shinn.model.Product;
import com.shinn.paging.Pageble;

import java.util.List;

public interface IProductService {
    public Product save(Product product);
    public List<Product> findAll(Pageble paging);
    public void delete(Product product);
    public void update(Product product);
    public Integer count();
}
