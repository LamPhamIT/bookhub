package com.shinntl.services.iservice;

import com.shinntl.model.User;

public interface IUserService {
//    public Long save(User user);
//    public void update(User user);
    public User findByUsernameAndPassword(String userName, String password);
}
