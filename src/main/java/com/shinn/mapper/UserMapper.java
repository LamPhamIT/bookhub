package com.shinn.mapper;

import com.shinn.model.Role;
import com.shinn.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("Account_ID"));
            user.setUserName(resultSet.getString("Username"));
            user.setPassword(resultSet.getString("password"));
            user.setRoleId(resultSet.getLong("Role_ID"));
            user.setCreatedDate(resultSet.getTimestamp("CreatedDate"));
            user.setCreatedBy(resultSet.getString("CreatedBy"));
            if(resultSet.getTimestamp("ModifiedDate") != null && resultSet.getString("ModifiedBy") != null) {
                user.setModifiedDate(resultSet.getTimestamp("ModifiedDate"));
                user.setModifiedBy(resultSet.getString("ModifiedBy"));
            }
            try {
                Role role = new Role();
                role.setId(user.getRoleId());
                role.setName(resultSet.getString("Name"));
                user.setRole(role);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}
