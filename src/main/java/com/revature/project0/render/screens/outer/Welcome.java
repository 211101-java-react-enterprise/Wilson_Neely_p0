package com.revature.project0.render.screens.outer;

import com.revature.project0.render.screens.View;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

import static com.revature.project0.util.AppStatus.stop;

public class Welcome extends View {
    public Welcome(Scanner consoleScanner, ScreenRouter router) {
        super("welcome", "/welcome", consoleScanner, router);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Welcome to Wilson's Banking App\n" +
                "Would you like to:\n" +
                "1. Login\n" +
                "2. Register\n" +
                "3. Exit\n" +
                ">");
        String ans = consoleScanner.next();

        switch (ans){
            case "1":
                router.navigate("/login");
                break;
            case "2":
                router.navigate("/register");
                break;
            case "3":
                stop();
                break;
        }
    }
}
