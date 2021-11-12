package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public class SendMoney extends View {
    public SendMoney(Scanner consoleScanner, ScreenRouter router) {
        super("sendmoney", "loggedin/sendmoney", consoleScanner, router);
    }

    @Override
    public void render() throws Exception {

    }
}
