package Test;

import com.shinn.dao.idao.IProductDAO;
import com.shinn.dao.impl.AbstractDAO;
import com.shinn.dao.impl.AccountDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.Account;
import com.shinn.model.Product;
import com.shinn.services.impl.ProductService;
import com.shinn.services.iservice.IProductService;

import javax.inject.Inject;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Product product = new Product();
        product.setName("Legion");
        product.setDescrip("Như cc");
        product.setDetails("Như cc");
        product.setPrice(200.0);
        product.setDiscount(23.4);
        product.setBrandId(1L);
        product.setNote("Nhu cc");
        IProductService productService = new ProductService();
        product = productService.save(product);
        System.out.println(product.toString());
    }
}
