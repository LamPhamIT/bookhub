package com.shinntl.controller.Admin;

import com.shinntl.constant.SystemConstant;
import com.shinntl.model.Brand;
import com.shinntl.model.Product;
import com.shinntl.paging.PageRequest;
import com.shinntl.paging.Pageble;
import com.shinntl.services.impl.BrandService;
import com.shinntl.services.impl.ProductService;
import com.shinntl.services.iservice.IBrandService;
import com.shinntl.services.iservice.IProductService;
import com.shinntl.sorter.Sorter;
import com.shinntl.utils.FormUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-products"})
public class ProductController extends HttpServlet {
    //    @Inject
//    private IProductService productService;  Fix
    private IProductService productService;
    private IBrandService brandService;

    public ProductController() {
        productService = new ProductService();
        brandService = new BrandService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = FormUtil.toModel(Product.class, request);
        String url = "";
        if (product.getType().equals(SystemConstant.LIST)) {
            Pageble paging = new PageRequest(product.getPage(), product.getMaxPageItem(),
                    new Sorter(product.getSortName(), product.getSortBy()));
            product.setListResult(productService.findAll(paging));
            product.setTotalItem(productService.count());
            product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItem()));

            url = "/views/admin/ListProduct.jsp";
        } else if (product.getType().equals(SystemConstant.EDIT)) {
            if(product.getId() != null) {
                product = productService.findOne(product.getId());
            } else {

            }
            List<Brand> l = brandService.findAll();
            request.setAttribute("Brands", brandService.findAll());
            url = "/views/admin/Edit.jsp";
        }
        request.setAttribute(SystemConstant.MODEL, product);
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
