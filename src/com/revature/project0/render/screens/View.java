package com.revature.project0.render.screens;

import java.util.Scanner;

public abstract class View {
    protected String name;
    protected String route;
    protected Scanner consoleScanner;

    public View(String name, String route, Scanner consoleScanner) {
        this.name = name;
        this.route = route;
        this.consoleScanner = consoleScanner;
    }

    public String getRoute() {
        return route;
    }

    public String getName() {
        return name;
    }

    public abstract void render() throws Exception;
}
