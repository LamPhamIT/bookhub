package com.shinntl.dao.impl;

import com.shinntl.dao.idao.IProductDAO;
import com.shinntl.mapper.ProductMapper;
import com.shinntl.model.Product;
import com.shinntl.paging.Pageble;

import java.util.List;

public class ProductDAO extends AbstractDAO<Product> implements IProductDAO {
    @Override
    public List<Product> findAll(Pageble paging) {
        StringBuilder sql = new StringBuilder("SELECT * FROM Product ");
        if(paging.getSorter().getSortBy() != null && paging.getSorter().getSortName() != null) {
            sql.append("ORDER BY " + paging.getSorter().getSortBy() + " " + paging.getSorter().getSortName());
        }
        if(paging.getOffset() != null && paging.getLimit() != null) {
            sql.append(" LIMIT " + paging.getOffset() +", " + paging.getLimit());
        }
        return query(sql.toString(), new ProductMapper());
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

    @Override
    public Integer count() {
        String sql = "SELECT COUNT(*) FROM Product";
        return count(sql);
    }
}
