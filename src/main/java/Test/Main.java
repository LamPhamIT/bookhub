package Test;

import com.shinn.dao.impl.AbstractDAO;
import com.shinn.dao.impl.AccountDAO;
import com.shinn.dao.impl.ProductDAO;
import com.shinn.model.Account;
import com.shinn.model.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Account account = new Account("customer1", "lamdeptrai", 2L);
        System.out.println("Result : " + new AccountDAO().insert(account));
    }
}
