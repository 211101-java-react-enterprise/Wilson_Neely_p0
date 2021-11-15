package com.revature.project0.services;

import com.revature.project0.DAOs.AccountsDAO;
import com.revature.project0.models.Accounts;
import com.revature.project0.util.Collections.LinkedList;



public class AccountsService implements DataService<Accounts>{
    private final AccountsDAO accountsDAO;

    public AccountsService(AccountsDAO DAO) {
        accountsDAO = DAO;
    }

    public Accounts authenticate(Accounts account) {
        return null;
    }

    public LinkedList<Accounts> findAll() {
        return accountsDAO.findAll();
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
