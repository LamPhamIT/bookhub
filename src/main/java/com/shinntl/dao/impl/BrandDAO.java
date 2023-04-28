package com.shinntl.dao.impl;

import com.shinntl.dao.idao.IBrandDAO;
import com.shinntl.mapper.BrandMapper;
import com.shinntl.model.Brand;

import java.util.List;

public class BrandDAO extends AbstractDAO<Brand> implements IBrandDAO {
    @Override
    public List<Brand> findAll() {
        String query = "SELECT * FROM Brand";
        return query(query, new BrandMapper());
    }

    @Override
    public Brand findOne(Long id) {
        String query = "SELECT * FROM Brand WHERE Brand_ID=?";
        List<Brand> list = query(query, new BrandMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Brand findByName(String name) {
        String query = "SELECT * FROM Brand WHERE Brand=?";
        List<Brand> list = query(query, new BrandMapper(), name);
        return list.isEmpty() ? null : list.get(0);
    }
}
