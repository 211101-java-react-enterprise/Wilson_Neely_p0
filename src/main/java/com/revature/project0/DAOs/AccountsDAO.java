package com.revature.project0.DAOs;

import com.revature.project0.models.Accounts;
import com.revature.project0.util.List;

public class AccountsDAO implements CrudDAO<Accounts>{
    @Override
    public Accounts save(Accounts newObj) {
        return null;
    }

    @Override
    public Accounts findById(String id) {
        return null;
    }

    @Override
    public List<Accounts> findAll() {
        return null;
    }

    @Override
    public boolean update(Accounts updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
