package Test;

import com.shinn.dao.impl.AbstractDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> list = new ProductDAO().findAll();
        for(Product p : list) {
            System.out.println("product: " + p.getName());
        }
    }
}
