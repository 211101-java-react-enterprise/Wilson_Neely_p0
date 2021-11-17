package com.revature.project0.render.screens.inner;

import com.revature.project0.models.Users;
import com.revature.project0.render.screens.View;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class LoggedIn extends View {

    private final UsersService usersService;

    public LoggedIn(Scanner consoleScanner, ScreenRouter router, UsersService usersService) {
        super("loggedin", "/loggedin", consoleScanner, router);
        this.usersService = usersService;
    }

    @Override
    public void render() throws Exception {
        Users sessionUser = usersService.getSessionUser();
        if (sessionUser == null) {
            System.out.println("You are not currently logged in! Navigating to Login Screen");
            router.navigate("/login");
            return;
        }
        while (usersService.isSessionActive()){
            System.out.printf("\nLogged in as %s \n", sessionUser.getFirstName());
            System.out.print("1) View/edit my bank accounts\n" +
                    "2) Create a bank account\n" +
                    "3) View my transaction history\n" +
                    "4) Deposit into an account\n" +
                    "5) Withdraw from your accounts\n" +
                    "6) Transfer money\n" +
                    "7) Logout\n" +
                    "> ");

            String selection = consoleScanner.nextLine();
            System.out.println();//for a newline after user input

            switch (selection) {
                case "1":
                    router.navigate("loggedin/accountview");
                    break;
                case "2":
                    router.navigate("loggedin/createaccount");
                    break;
                case "3":
                    router.navigate("/flashcards");
                    break;
                case "4":
                    router.navigate("loggedin/deposit");
                    break;
                case "5":
                    router.navigate("loggedin/withdraw");
                    break;
                case "6":
                    router.navigate("loggedin/sendmoney");
                    break;
                case "7":
                    usersService.logout();
                    break;
                default:
                    System.out.println("You have made an invalid selection");
            }
        }
    }
}
