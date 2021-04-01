package com.purvesh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginFlow {
    public static String checkLogin(String id, String pass) throws SQLException {
        Connection con = SqlConnector.getConnection();
        System.out.println("login flow");
        String email = id;
        String password = pass;
        if(true){
            System.out.println(" email is " + email);
            System.out.println(" pass code is  " + password);
            Login lg = new Login();
            lg.setEmail(email);
            lg.setPassword(password);
            String query2 = "select * from users where email = '"  + lg.getEmail() + "' AND password = '"  + lg.getPassword() + "' ";
            System.out.println( "query 2 = " + query2);
            PreparedStatement st = con.prepareStatement(query2);
            ResultSet rt = st.executeQuery(query2);
            if (rt.next()) {
                return "welcome";
            }
            else {
                return "Invalid credentials";
            }
        }
        return "";
    }
}
