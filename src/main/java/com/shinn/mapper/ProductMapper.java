package com.shinn.mapper;

import com.shinn.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet) {
        try {
            Product product = new Product();
            product.setId(resultSet.getLong("Product_ID"));
            product.setName(resultSet.getString("Name"));
            product.setDescrip(resultSet.getString("Descrip"));
            product.setDetails(resultSet.getString("Details"));
            product.setPrice(resultSet.getDouble("Price"));
            product.setDiscount(resultSet.getDouble("Discount"));
            return product;
        } catch (SQLException e) {
            return null;
        }

    }
}
