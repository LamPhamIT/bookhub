package com.shinn.dao.idao;

import com.shinn.model.Account;

import java.util.List;

public interface IAccountDAO {
    List<Account> findAll();
    Long insert(Account account);
}
