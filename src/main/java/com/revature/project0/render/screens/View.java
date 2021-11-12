package com.revature.project0.render.screens;

import com.revature.project0.util.ScreenRouter;

import java.util.Scanner;

public abstract class View {
    protected String name;
    protected String route;
    protected Scanner consoleScanner;
    protected ScreenRouter router;

    public View(){

    }

    public View(String name, String route, Scanner consoleScanner, ScreenRouter router) {
        this.name = name;
        this.route = route;
        this.consoleScanner = consoleScanner;
        this.router = router;
    }

    public String getRoute() {
        return route;
    }

    public String getName() {
        return name;
    }

    public abstract void render() throws Exception;
}
