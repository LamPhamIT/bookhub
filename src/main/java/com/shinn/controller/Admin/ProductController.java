package com.shinn.controller.Admin;

import com.shinn.constant.SystemConstant;
import com.shinn.model.Product;
import com.shinn.paging.PageRequest;
import com.shinn.paging.Pageble;
import com.shinn.services.impl.ProductService;
import com.shinn.services.iservice.IProductService;
import com.shinn.sorter.Sorter;
import com.shinn.utils.FormUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-products"})
public class ProductController extends HttpServlet {
//    @Inject
//    private IProductService productService;  Fix
    private IProductService productService;
    public ProductController() {
        productService = new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = FormUtil.toModel(Product.class, request);
        Pageble paging = new PageRequest(product.getPage(), product.getMaxPageItem(),
                                            new Sorter(product.getSortName(), product.getSortBy()));
        product.setListResult(productService.findAll(paging));
        product.setTotalItem(productService.count());
        product.setTotalPage((int) Math.ceil((double) product.getTotalItem() / product.getMaxPageItem()));
        request.setAttribute(SystemConstant.MODEL, product);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/ListProduct.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
