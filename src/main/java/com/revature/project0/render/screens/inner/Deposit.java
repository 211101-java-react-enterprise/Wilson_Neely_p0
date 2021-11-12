package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class Deposit extends View {
    public Deposit(Scanner consoleScanner, ScreenRouter router) {
        super("Deposit", "loggedin/deposit", consoleScanner, router);
    }

    @Override
    public void render() throws Exception {

    }
}
