package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class Withdraw extends View {
    public Withdraw(Scanner consoleScanner, ScreenRouter router) {
        super("Withdraw", "loggedin/withdraw", consoleScanner, router);
    }

    @Override
    public void render() throws Exception {

    }
}
