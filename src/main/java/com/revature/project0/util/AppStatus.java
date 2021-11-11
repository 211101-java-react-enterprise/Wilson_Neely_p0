package com.revature.project0.util;

import java.util.Scanner;

public class AppStatus {

    private static boolean isRunning;

    public AppStatus(){
        isRunning = true;

        //Get what I need for resource injection
        Scanner consoleReader = new Scanner(System.in);

    }

    public void start(){
        try{
            while(isRunning){
                System.out.println("Inf loop rn");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void stop(){
        isRunning = false;
    }
}
