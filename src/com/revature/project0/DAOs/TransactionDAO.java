package com.revature.project0.DAOs;

import com.revature.project0.models.Transactions;
import com.revature.project0.util.List;

public class TransactionDAO implements CrudDAO<Transactions>{
    @Override
    public Transactions save(Transactions newObj) {
        return null;
    }

    @Override
    public Transactions findById(String id) {
        return null;
    }

    @Override
    public List<Transactions> findAll() {
        return null;
    }

    @Override
    public boolean update(Transactions updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
