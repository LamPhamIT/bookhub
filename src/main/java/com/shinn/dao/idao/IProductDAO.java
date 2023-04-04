package com.shinn.dao.idao;

import com.shinn.model.Product;
import com.shinn.paging.Pageble;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll(Pageble paging);
    Long insert(Product product);
    Product findOne(Long productId);
    void deleteOne(Long productId);
    void update(Product product);

    Integer count();
}
