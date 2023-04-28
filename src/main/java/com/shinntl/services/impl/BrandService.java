package com.shinntl.services.impl;

import com.shinntl.dao.idao.IBrandDAO;
import com.shinntl.dao.impl.BrandDAO;
import com.shinntl.model.Brand;
import com.shinntl.services.iservice.IBrandService;

import java.util.List;

public class BrandService implements IBrandService {
    private IBrandDAO  brandDAO;
    public BrandService() {
        brandDAO = new BrandDAO();
    }
    @Override
    public List<Brand> findAll() {
        return brandDAO.findAll();
    }

    @Override
    public Brand findOne(Long id) {
        return brandDAO.findOne(id);
    }

    @Override
    public Brand findByName(String name) {
        return brandDAO.findByName(name);
    }
}
