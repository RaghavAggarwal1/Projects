package com.purvesh.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/movies";
        try {
           con = DriverManager.getConnection(url, "root", "87654321");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Connection established");

        return con;
    }
}
