package com.revature.project0.util;

import com.revature.project0.DAOs.AccountsDAO;
import com.revature.project0.DAOs.TransactionDAO;
import com.revature.project0.DAOs.UsersDAO;
import com.revature.project0.render.screens.inner.*;
import com.revature.project0.render.screens.outer.Login;
import com.revature.project0.render.screens.outer.Register;
import com.revature.project0.render.screens.outer.Welcome;
import com.revature.project0.services.AccountsService;
import com.revature.project0.services.TransactionsService;
import com.revature.project0.services.UsersService;

import java.util.Scanner;

public class AppStatus {

    private static boolean isRunning;
    private final ScreenRouter router;

    public AppStatus(){
        isRunning = true;
        router = new ScreenRouter();
        //Get what I need for resource injection
        UsersDAO usersDAO = new UsersDAO();
        UsersService usersService = new UsersService(usersDAO);
        Scanner consoleReader = new Scanner(System.in);
        AccountsDAO accountsDAO = new AccountsDAO(usersService);
        TransactionDAO transDAO = new TransactionDAO();
        AccountsService accountsService = new AccountsService(accountsDAO);
        TransactionsService transactionsService = new TransactionsService(transDAO);
        router.addScreen(new Welcome(consoleReader, router));
        router.addScreen(new Login(consoleReader, router, usersService));
        router.addScreen(new Register(consoleReader, router, usersService));
        router.addScreen(new LoggedIn(consoleReader, router, usersService));
        router.addScreen(new Deposit(consoleReader, router, usersService, accountsService));
        router.addScreen(new Withdraw(consoleReader, router, usersService, accountsService));
        router.addScreen(new CreateAccount(consoleReader, router, usersService, accountsService));
        router.addScreen(new AccountView(consoleReader, router, usersService, accountsService));
        router.addScreen(new TransactionHist(consoleReader, router, usersService, accountsService));

    }

    public void start(){
        try{
            while(isRunning){
                router.navigate("/welcome");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void stop(){
        isRunning = false;
    }
}
