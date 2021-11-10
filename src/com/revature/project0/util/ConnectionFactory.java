package com.revature.project0.util;

/*
    Singleton design pattern
    creational pattern
    restricts a class so the only a single instance can be made within an application
    constructor cannot be called outside of class

    factory design pattern
    creational pattern
    used to abstract the creation/instantiation logic of an object
 */
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    static{
        try{
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private static final ConnectionFactory connectionFactory = new ConnectionFactory();
    private Properties props = new Properties();
    private ConnectionFactory(){
        try {
            props.load(new FileReader("resources/DB.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance(){
        return connectionFactory;
    }

    public Connection getConnection() {
        Connection conn = null;

        try{
            conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("username"), props.getProperty("password"));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
}
