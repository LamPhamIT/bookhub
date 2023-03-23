package com.shinn.dao.impl;

import com.shinn.dao.idao.IAccountDAO;
import com.shinn.mapper.AccountMapper;
import com.shinn.model.Account;

import java.util.List;

public class AccountDAO extends AbstractDAO<Account> implements IAccountDAO {

    @Override
    public List<Account> findAll() {
        String sql = "Select * from Account";
        return query(sql, new AccountMapper());
    }

    @Override
    public Long insert(Account account) {
        String sql = "INSERT INTO Account(Username, Password, Role_ID, CreatedDate, CreatedBy) values(?, ?, ?, ?, ?)";
        return insert(sql, account.getUserName(), account.getPassword(), account.getRoleID(), account.getCreatedDate(),
                        account.getCreatedBy());
    }

}
