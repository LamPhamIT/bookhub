package com.shinn.dao.impl;

import com.shinn.dao.idao.IProductDAO;
import com.shinn.mapper.ProductMapper;
import com.shinn.model.Product;

import java.util.List;

public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {
    @Override
    public List<Product> findAll() {
        String sql = "Select * from product";
        return query(sql, new ProductMapper());
    }
}
