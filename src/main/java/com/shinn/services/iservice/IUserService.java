package com.shinn.services.iservice;

import com.shinn.model.User;

public interface IUserService {
//    public Long save(User user);
//    public void update(User user);
    public User findByUsernameAndPassword(String userName, String password);
}
