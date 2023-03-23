package com.shinn.services.iservice;

import com.shinn.model.Account;

public interface IAccountService {
    public Long save(Account account);
    public void update(Account account);
}
