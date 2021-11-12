package com.revature.project0.services;

import com.revature.project0.DAOs.UsersDAO;
import com.revature.project0.models.Users;

public class UsersService implements DataService<Users> {
    private final UsersDAO userDAO;
    private Users sessionUser;

    public UsersService(UsersDAO DAO) {
        this.sessionUser = null;
        this.userDAO = DAO;
    }

    public Users getSessionUser() {
        return sessionUser;
    }

    @Override
    public Users authenticate(Users user) {
        return null;
    }

    @Override
    public boolean register(Users user) {
        return false;
    }

    @Override
    public boolean validate(Users user) {
        return false;
    }
}
