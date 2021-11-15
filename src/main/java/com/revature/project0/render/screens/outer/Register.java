package com.revature.project0.render.screens.outer;

import com.revature.project0.exceptions.InvalidRequestException;
import com.revature.project0.exceptions.ResourcePersistenceException;
import com.revature.project0.models.Users;
import com.revature.project0.render.screens.View;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class Register extends View {

    private final UsersService usersService;

    public Register(Scanner consoleScanner, ScreenRouter router, UsersService usersService) {
        super("register", "/register", consoleScanner, router);
        this.usersService = usersService;
    }
    @Override
    public void render() throws Exception {
        String firstName;
        String lastName;
        String email;
        String username;
        String password;

        System.out.println("User selected to register");
        System.out.println("Please provide us with some basic information.");

        System.out.print("What is your first name?\n> ");
        firstName = consoleScanner.next();

        System.out.print("\nWhat is your last name?\n> ");
        lastName = consoleScanner.next();

        System.out.print("\nWhat is your email?\n> ");
        email = consoleScanner.next();

        System.out.print("\nWhat is your username?\n> ");
        username = consoleScanner.next();

        System.out.print("\nWhat is your password?\n> ");
        password = consoleScanner.next();

        System.out.print("\n");


        System.out.printf("Provided user first and last name: { \"firstName\": %s, \"lastName\": %s}\n", firstName, lastName);
        // String format specifiers: %s (strings), %d (whole numbers), %f (decimal values)
        Users newUser = new Users(firstName,lastName,email,username,password);

        try {
            usersService.registerNewUser(newUser);
            router.navigate("/dashboard");

        }catch (InvalidRequestException | ResourcePersistenceException e){
            System.out.println(e.getMessage());
        } catch(Exception e){
            //TODO logging
            System.out.println("There was an issue when trying to persist the user to the datasource.");
        }
    }
}
