package com.shinn.services.impl;

import com.shinn.dao.idao.IUserDAO;
import com.shinn.dao.impl.UserDAO;
import com.shinn.model.User;
import com.shinn.services.iservice.IUserService;

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
