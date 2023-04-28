package com.shinntl.mapper;

import com.shinntl.model.Product;

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

            // Set kiểu dữ liệu Blob


            product.setBrandId(resultSet.getLong("Brand_ID"));
            product.setNote(resultSet.getString("Note"));
            product.setCreatedDate(resultSet.getTimestamp("Createddate"));
            product.setCreatedBy(resultSet.getString("Createdby"));



            if(resultSet.getTimestamp("Modifieddate") != null) {
                product.setModifiedDate(resultSet.getTimestamp("Modifieddate"));
            }
            if(resultSet.getString("Modifiedby") != null) {
                product.setModifiedBy(resultSet.getString("Modifiedby"));
            }

            return product;
        } catch (SQLException e) {
            return null;
        }

    }
}
