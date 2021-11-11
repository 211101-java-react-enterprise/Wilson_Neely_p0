package com.revature.project0.DAOs;

import com.revature.project0.models.Users;
import com.revature.project0.util.List;

public class UsersDAO implements CrudDAO<Users> {
    @Override
    public Users save(Users newObj) {
        return null;
    }

    @Override
    public Users findById(String id) {
        return null;
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public boolean update(Users updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}
