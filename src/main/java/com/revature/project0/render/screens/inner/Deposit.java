package com.revature.project0.render.screens.inner;

import com.revature.project0.models.Accounts;
import com.revature.project0.models.Users;
import com.revature.project0.render.screens.View;
import com.revature.project0.services.AccountsService;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.Collections.LinkedList;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class Deposit extends View {

    private final UsersService usersService;
    private final AccountsService accountsService;

    public Deposit(Scanner consoleScanner, ScreenRouter router, UsersService usersService, AccountsService accountsService) {
        super("Deposit", "loggedin/deposit", consoleScanner, router);
        this.usersService = usersService;
        this.accountsService = accountsService;
    }

    @Override
    public void render() throws Exception {
        Users sessionUser = usersService.getSessionUser();
        System.out.printf("Welcome %s, what account would you like to deposit into?\n", sessionUser.getFirstName());
        LinkedList<Accounts> accountsList = accountsService.findAll();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < accountsList.size(); i++){
            sb.append(accountsList.get(i).getId() + " " + accountsList.get(i).getName());
            if (i+1 != accountsList.size()){
                sb.append(" ");
            }
        }
        System.out.println(sb);
        System.out.println("Enter the account number");
        System.out.print("> ");

        String choice = consoleScanner.next();
        //TODO finish this
    }
}
