package com.shinn.dao.impl;

import com.shinn.dao.idao.IUserDAO;
import com.shinn.mapper.UserMapper;
import com.shinn.model.User;

import java.util.List;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {

    @Override
    public List<User> findAll() {
        String sql = "Select * from User";
        return query(sql, new UserMapper());
    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO User(Username, Password, Role_ID, CreatedDate, CreatedBy) values(?, ?, ?, ?, ?)";
        return insert(sql, user.getUserName(), user.getPassword(), user.getRole().getId(), user.getCreatedDate(),
                        user.getCreatedBy());
    }

    @Override
    public User findByUsernameAndPassword(String userName, String password) {
        StringBuilder sql = new StringBuilder("SELECT u.*, r.Name FROM User AS u INNER JOIN Role AS r ");
        sql.append("ON r.Role_ID=u.Role_ID WHERE u.Username=? AND u.Password=?");
        List<User> listResult = query(sql.toString(), new UserMapper(), userName, password);
        if(listResult.isEmpty()) {
            return null;
        }
        return listResult.get(0);
    }
}
