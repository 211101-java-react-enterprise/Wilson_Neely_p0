package com.revature.project0.render.screens.outer;

import com.revature.project0.exceptions.AuthenticationException;
import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.render.screens.View;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class Login extends View {

    private final UsersService usersService;

    public Login(Scanner consoleScanner, ScreenRouter router, UsersService usersService) {
        super("login", "/login", consoleScanner, router);
        this.usersService = usersService;
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
            usersService.authenticateUser(username, password);
            router.navigate("/dashboard");
        } catch (InvalidRequestException | AuthenticationException e) {
            //TODO logging
            System.out.println(e.getMessage());
        }
    }
}
