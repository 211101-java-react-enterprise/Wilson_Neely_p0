package com.revature.project0.services;

import com.revature.project0.DAOs.AccountsDAO;
import com.revature.project0.models.Accounts;


public class AccountsService implements DataService<Accounts>{
    private final AccountsDAO accountsDAO;

    public AccountsService(AccountsDAO DAO) {
        accountsDAO = DAO;
    }

    @Override
    public Accounts authenticate(Accounts account) {
        return null;
    }

    @Override
    public boolean register(Accounts account) {
        return false;
    }

    @Override
    public boolean validate(Accounts account) {
        return false;
    }
}
