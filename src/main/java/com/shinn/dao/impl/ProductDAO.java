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
                    product.getPrice(), product.getDiscount(), "", product.getBrandId(), product.getNote(),
                    product.getCreatedDate(), product.getCreatedBy());

    }

    @Override
    public Product findOne(Long productId) {
        String sql = "SELECT * FROM Product WHERE Product_ID = ?";
        List<Product> list = query(sql, new ProductMapper(), productId);
        if(list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void deleteOne(Long productId) {
        String sql = "DELETE FROM Product Where Product_ID = ?";
        update(sql, productId);
    }

    @Override
    public void update(Product product) {
        StringBuilder stringBuilder = new StringBuilder("UPDATE Product SET Name=?, Descrip=?, Details=?,");
        stringBuilder.append("Price=?, Discount=?, Image=?, Brand_ID=?, Note=? WHERE Product_ID=?");
        update(stringBuilder.toString(), product.getName(), product.getDescrip(), product.getDetails(), product.getPrice(),
                product.getDiscount(), "", product.getBrandId(), product.getNote(), product.getId());
    }
}
