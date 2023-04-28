package com.shinntl.services.impl;

import com.shinntl.dao.idao.IProductDAO;
import com.shinntl.dao.impl.ProductDAO;
import com.shinntl.model.Brand;
import com.shinntl.model.Product;
import com.shinntl.paging.Pageble;
import com.shinntl.services.iservice.IBrandService;
import com.shinntl.services.iservice.IProductService;

import java.sql.Timestamp;
import java.util.List;

public class ProductService implements IProductService {

//    @Inject
//    private IProductDAO productDAO;   Fix

    private IProductDAO productDAO;
    private IBrandService brandService;

    public ProductService() {
        productDAO = new ProductDAO();
        brandService = new BrandService();
    }

    @Override
    public Product save(Product product) {
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
//        product.setCreatedBy("");
        Brand brand = brandService.findByName(product.getBrand());
        product.setBrandId(brand.getId());
        Long productID = productDAO.insert(product);
        return productDAO.findOne(productID);
    }

    @Override
    public List<Product> findAll(Pageble paging) {
        return productDAO.findAll(paging);
    }

    @Override
    public void delete(Product product) {
        for (Long productID : product.getIds()) {
            productDAO.deleteOne(productID);
        }
    }

    @Override
    public void update(Product product) {
        product.setModifiedDate(new Timestamp(System.currentTimeMillis()));
        Brand brand = brandService.findByName(product.getBrand());
        product.setBrandId(brand.getId());
        product.setModifiedBy("Admin1");
        productDAO.update(product);
    }

    @Override
    public Integer count() {
        return productDAO.count();
    }

    @Override
    public Product findOne(Long id) {
        Product product = productDAO.findOne(id);
        Brand brand = brandService.findOne(product.getBrandId());
        product.setBrand(brand.getName());
        return product;
    }
}
