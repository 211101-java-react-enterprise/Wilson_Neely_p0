package com.revature.project0.render.screens.inner;

import com.revature.project0.render.screens.View;
import com.revature.project0.util.ScreenRouter;


import java.util.Scanner;

public class AccountView extends View {
    public AccountView(Scanner consoleScanner, ScreenRouter router) {
        super("accountview", "loggedin/accountview", consoleScanner, router);
    }

    @Override
    public void render() throws Exception {

    }
}
