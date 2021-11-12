package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class TransactionHist extends View {

    public TransactionHist(Scanner consoleScanner, ScreenRouter router) {
        super("TransactionHistory", "loggedin/transactionhistory", consoleScanner, router);
    }

    @Override
    public void render() throws Exception {

    }
}
