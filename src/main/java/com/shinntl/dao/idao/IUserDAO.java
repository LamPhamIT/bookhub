package com.shinntl.dao.idao;

import com.shinntl.model.User;

import java.util.List;

public interface IUserDAO {
    List<User> findAll();
    Long insert(User user);

    User findByUsernameAndPassword(String userName, String password);
}
