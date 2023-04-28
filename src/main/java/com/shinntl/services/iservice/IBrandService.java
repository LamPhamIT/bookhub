package com.shinntl.services.iservice;

import com.shinntl.dao.idao.IBrandDAO;
import com.shinntl.model.Brand;

import java.util.List;

public interface IBrandService {
   public List<Brand> findAll();
   public Brand findOne(Long id);
   public Brand findByName(String name);
}
