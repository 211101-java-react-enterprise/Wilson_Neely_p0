package com.revature.project0.render.screens.inner;

import com.revature.project0.models.Accounts;
import com.revature.project0.render.screens.View;
import com.revature.project0.services.AccountsService;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.Collections.LinkedList;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class TransactionHist extends View {

    private final UsersService usersService;
    private final AccountsService accountsService;

    public TransactionHist(Scanner consoleScanner, ScreenRouter router, UsersService usersService, AccountsService accountsService) {
        super("TransactionHistory", "loggedin/transactionhistory", consoleScanner, router);
        this.usersService = usersService;
        this.accountsService = accountsService;
    }

    @Override
    public void render() throws Exception {
        boolean exit = false;
        do{
        System.out.printf("Welcome %s , what type of transactions would you like to see?\n" +
                "1. Deposits and Withdrawals on my accounts\n" +
                "2. Transactions to and from other users\n" +
                "3. Go back\n" +
                "> ", usersService.getSessionUser().getFirstName());
        String ans = consoleScanner.nextLine();
        System.out.println();
        switch (ans) {
            case "1":
                LinkedList<Accounts> acc = accountsService.findAll();
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < acc.size(); i++){
                    sb.append(acc.get(i).getId() + " " + acc.get(i).getName() + " ");
                }
                System.out.println(sb);
                System.out.print("Enter the account id you would like to see transactions for:\n> ");
                ans = consoleScanner.nextLine();
                if(accountsService.accIdInList(acc, ans)){
                    String name = null;
                    for (Accounts a:acc) {
                        if(a.getId() == Integer.parseInt(ans)) name = a.getName();
                    }
                    System.out.println(accountsService.transactionHistString(ans, name));
                }else System.out.println("Invalid account id");
                break;
            case "2":
                System.out.println("NYI");
                break;
            case "3":
                exit =true;
                break;
            default:
                System.out.println("Invalid input, try again.");
            }
        }while (!exit);
    }
}
