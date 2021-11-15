package com.revature.project0.util;

import com.revature.project0.DAOs.AccountsDAO;
import com.revature.project0.DAOs.TransactionDAO;
import com.revature.project0.DAOs.UsersDAO;
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
        Scanner consoleReader = new Scanner(System.in);
        AccountsDAO accountsDAO = new AccountsDAO();
        TransactionDAO transDAO = new TransactionDAO();
        UsersDAO usersDAO = new UsersDAO();
        AccountsService accountsService = new AccountsService(accountsDAO);
        TransactionsService transactionsService = new TransactionsService(transDAO);
        UsersService usersService = new UsersService(usersDAO);
        router.addScreen(new Welcome(consoleReader, router));
        router.addScreen(new Login(consoleReader, router, usersService));
        router.addScreen(new Register(consoleReader, router, usersService));

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
