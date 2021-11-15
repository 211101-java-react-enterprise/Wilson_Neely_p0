package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.services.AccountsService;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class Withdraw extends View {

    private final UsersService usersService;
    private final AccountsService accountsService;

    public Withdraw(Scanner consoleScanner, ScreenRouter router, UsersService usersService, AccountsService accountsService) {
        super("Withdraw", "loggedin/withdraw", consoleScanner, router);
        this.usersService = usersService;
        this.accountsService = accountsService;
    }

    @Override
    public void render() throws Exception {

    }
}
