package com.example.demo1.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectProvided {
    private final static DBConnectProvided INSTACE = new DBConnectProvided();
    private static Connection connection;
    private final static String url = "jdbc:mysql://localhost:3306/smart?useUnicode=true";
    private final static String name = "man";
    private final static String password = "manuk2000";
    private DBConnectProvided(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading MySQL JDBC driver");
        }    }

    public Connection getConnection() {
        try {
            if(connection == null || connection.isClosed()){
                connection = DriverManager.getConnection(url ,name , password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DBConnectProvided getInstace(){
        return INSTACE;
    }
}
