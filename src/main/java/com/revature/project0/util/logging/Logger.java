package com.revature.project0.util.logging;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Logger {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private static Logger logger;
    private final boolean printToConsole;

    private Logger(boolean printToConsole) {
        this.printToConsole = printToConsole;
    }

    public static Logger getLogger(boolean printToConsole) {
        if (logger == null) {
            logger = new Logger(printToConsole);
        }

        return logger;
    }

    public void info(String message) {
        System.out.println(ANSI_GREEN + " INFO " + ANSI_RESET + message);
    }

    public void warn(String message) {
        System.out.println(ANSI_BLUE + " INFO " + ANSI_RESET + message);
    }

    public void error(String message) {
        System.out.println(ANSI_YELLOW + " INFO " + ANSI_RESET + message);
    }

    public void fatal(String message) {
        System.out.println(ANSI_RED + " INFO " + ANSI_RESET + message);
    }

    public void log(String message, int level, Object... args) {

        try (Writer logWriter = new FileWriter("src/main/resources/logs/app.log", true)) {

            String formattedMsg = String.format(message, args);
            logWriter.write(formattedMsg + "\n");

            if (printToConsole) {
                switch (level) {
                    case 1:
                        info(formattedMsg);
                        break;
                    case 2:
                        warn(formattedMsg);
                        break;
                    case 3:
                        error(formattedMsg);
                        break;
                    case 4:
                        fatal(formattedMsg);
                        break;
                    default:

                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}