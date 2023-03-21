package com.shinn.mapper;

import com.shinn.model.Account;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements RowMapper<Account>{
    @Override
    public Account mapRow(ResultSet resultSet) {
        Account account = new Account();
        try {
            account.setId(resultSet.getLong("Account_ID"));
            account.setUserName(resultSet.getString("Username"));
            account.setPassword(resultSet.getString("password"));
            account.setRoleID(resultSet.getLong("Role_ID"));
            account.setCreatedDate(resultSet.getTimestamp("CreatedDate"));
            account.setModifiedDate(resultSet.getTimestamp("ModifiedDate"));
            account.setCreatedBy(resultSet.getString("CreatedBy"));
            account.setModifiedBy(resultSet.getString("ModifiedBy"));
            return account;
        } catch (SQLException e) {
            return null;
        }
    }
}
