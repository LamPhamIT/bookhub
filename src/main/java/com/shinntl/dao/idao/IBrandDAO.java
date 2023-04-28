package com.shinntl.dao.idao;

import com.shinntl.model.Brand;

import java.util.List;

public interface IBrandDAO {
    public List<Brand> findAll();
    public Brand findOne(Long id);
    public Brand findByName(String name);
}
