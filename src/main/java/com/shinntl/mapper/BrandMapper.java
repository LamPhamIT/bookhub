package com.shinntl.mapper;

import com.shinntl.model.Brand;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandMapper implements RowMapper<Brand> {
    @Override
    public Brand mapRow(ResultSet resultSet) {
        Brand brand = new Brand();
        try {
            brand.setId(resultSet.getLong("Brand_ID"));
            brand.setName(resultSet.getString("Brand"));
            brand.setCreatedDate(resultSet.getTimestamp("Createddate"));
            brand.setCreatedBy(resultSet.getString("Createdby"));
            if(resultSet.getTimestamp("Modifieddate") != null) {
                brand.setModifiedDate(resultSet.getTimestamp("Modifieddate"));
            }
            if(resultSet.getString("Modifiedby") != null) {
                brand.setModifiedBy(resultSet.getString("Modifiedby"));
            }
            return brand;
        } catch (SQLException e) {
            return null;
        }

    }
}
