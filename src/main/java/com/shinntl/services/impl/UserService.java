package com.shinntl.services.impl;

import com.shinntl.dao.idao.IUserDAO;
import com.shinntl.dao.impl.UserDAO;
import com.shinntl.model.User;
import com.shinntl.services.iservice.IUserService;

public class UserService implements IUserService {
    private IUserDAO userDAO;
    public  UserService() {
        userDAO = new UserDAO();
    }
    @Override
    public User findByUsernameAndPassword(String userName, String password) {
        return userDAO.findByUsernameAndPassword(userName, password);
    }
}
