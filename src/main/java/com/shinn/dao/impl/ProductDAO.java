package com.shinn.dao.impl;

import com.shinn.dao.idao.IProductDAO;
import com.shinn.mapper.ProductMapper;
import com.shinn.model.Product;

import java.util.List;

public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {
    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM Product";
        return query(sql, new ProductMapper());
    }

    @Override
    public Long insert(Product product) {
        StringBuilder sql = new StringBuilder("INSERT INTO Product(Name, Descrip, Details, ");
        sql.append("Price, Discount, Image ,Brand_ID, Note, CreatedDate, CreatedBy) ");
        sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
        return insert(sql.toString(), product.getName(), product.getDescrip(), product.getDetails(),
                    product.getPrice(), product.getDiscount(), "", product.getBrandID(), product.getNote(),
                    product.getCreatedDate(), product.getCreatedBy());

    }

    @Override
    public Product findOne(Long productID) {
        String sql = "SELECT * FROM Product WHERE Product_ID = ?";
        List<Product> list = query(sql, new ProductMapper(), productID);
        if(list != null) {
            return list.get(0);
        }
        return null;
    }
}
