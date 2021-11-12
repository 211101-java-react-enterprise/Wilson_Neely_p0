package com.revature.project0.render.screens.outer;

import com.revature.project0.exceptions.AuthenticationException;
import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.render.screens.View;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class Login extends View {

    public Login(Scanner consoleScanner, ScreenRouter router) {
        super("login", "/login", consoleScanner, router);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Please enter an existing username and password");
        System.out.print("USERNAME: ");
        String username = consoleScanner.next();
        System.out.print("\nPASSWORD: ");
        String password = consoleScanner.next();
        System.out.println();

        try {
            //TODO re-implement later
            //UsersService.authenticateUser(username, password);
            router.navigate("/dashboard");
        } catch (InvalidRequestException | AuthenticationException e) {
            System.out.println(e.getMessage());
        }
    }
}
