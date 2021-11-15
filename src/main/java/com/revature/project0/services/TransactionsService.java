package com.revature.project0.services;

import com.revature.project0.DAOs.TransactionDAO;
import com.revature.project0.models.Transactions;

public class TransactionsService implements DataService<Transactions>{

    private final TransactionDAO transDAO;

    public TransactionsService(TransactionDAO DAO) {
        transDAO = DAO;
    }

    public Transactions authenticate(Transactions Obj) {
        return null;
    }

    @Override
    public boolean register(Transactions Obj) {
        return false;
    }

    @Override
    public boolean validate(Transactions Obj) {
        return false;
    }
}
