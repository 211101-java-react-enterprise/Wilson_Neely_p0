package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.services.UsersService;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class LoggedIn extends View {

    private final UsersService usersService;

    public LoggedIn(Scanner consoleScanner, ScreenRouter router, UsersService usersService) {
        super("loggedin", "loggedin", consoleScanner, router);
        this.usersService = usersService;
    }

    @Override
    public void render() throws Exception {
        
    }
}
