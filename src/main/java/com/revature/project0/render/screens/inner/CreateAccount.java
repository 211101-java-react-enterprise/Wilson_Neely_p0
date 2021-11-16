package com.revature.project0.render.screens.inner;

import com.revature.project0.models.Accounts;
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
        System.out.println("Welcome to the Bank Account generation wizard, first off what type of account would you like to create?");
        boolean corr = false;
        String ans;
        do {
            System.out.println("The account types available to you are Checking or Savings. Enter Cancel to go back.");
            System.out.print("> ");
            ans = consoleScanner.next();
            System.out.println();
            switch(ans){
                case "Checking":
                case "Savings":
                    corr = true;
                    break;
                case "Cancel":
                    return;
                default:
                    System.out.println("Invalid choice, try again");
            }
        }while(!corr);
        System.out.println("What would like like to name the account? (ex: Shared savings with brother) Max 50 chars.");
        String name = consoleScanner.next();
        accountsService.register(new Accounts(ans, name, usersService.getSessionUser().getId()));
    }
}
