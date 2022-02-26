package com.example.ecommercesoap;

import java.sql.Connection;

public class DB {
    public static Connection connection;

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/ecommerce";
        String dbName = "ecommerce";
        String userName = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(url, userName, password);
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return connection;
    }
}
