package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.services.AccountsService;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class CreateAccount extends View {

    private final UsersService usersService;
    private final AccountsService accountsService;

    public CreateAccount(Scanner consoleScanner, ScreenRouter router, UsersService usersService, AccountsService accountsService) {
        super("createaccount", "loggedin/createaccount", consoleScanner, router);
        this.usersService = usersService;
        this.accountsService = accountsService;
    }

    @Override
    public void render() throws Exception {

    }
}
