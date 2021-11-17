package com.revature.project0.render.screens.inner;

import com.revature.project0.models.Accounts;
import com.revature.project0.render.screens.View;
import com.revature.project0.services.AccountsService;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.Collections.LinkedList;
import com.revature.project0.util.ScreenRouter;
import java.util.Scanner;


public class AccountView extends View {

    private final UsersService usersService;
    private final AccountsService accountsService;

    public AccountView(Scanner consoleScanner, ScreenRouter router, UsersService usersService, AccountsService accountsService) {
        super("accountview", "loggedin/accountview", consoleScanner, router);
        this.usersService = usersService;
        this.accountsService = accountsService;
    }

    @Override
    public void render() throws Exception {
        boolean exit = false;
        do {
            System.out.print("What would you like to do?\n" +
                    "1. View your accounts\n" +
                    "2. Delete one of your accounts\n" +
                    "3. Add another person to an account\n" +
                    "4. Go back\n" +
                    "> ");
            String ans = consoleScanner.nextLine();
            System.out.println();
            LinkedList<Accounts> acc = accountsService.findAll();
            switch (ans){
                case "1":
                    for (Accounts ac: acc) System.out.println(ac);
                    break;
                case "4":
                    exit = true;
                    break;
                case "2":
                    System.out.print("What account do you wish to delete?\n> ");
                    ans =  consoleScanner.nextLine();
                    System.out.println();
                    if(accountsService.accIdInList(acc, ans)){
                        accountsService.remove(ans);
                    }break;
                case "3":
                    //TODO
                    System.out.println("NYI");
                    break;
                default:
                    System.out.println("Invalid selection, try again.");
            }
        }while (!exit);
    }
}
