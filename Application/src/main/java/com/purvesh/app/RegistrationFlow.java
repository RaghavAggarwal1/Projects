package com.purvesh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationFlow {
    public static String getRegistration(String name, String age1, String email, String password) throws SQLException {
        {
            String query = null;
            Connection con = SqlConnector.getConnection();
            System.out.println("register flow");

            int age = Integer.parseInt(age1);
            if (age > 0) {
                System.out.println("proceed");
                    Registration registration = new Registration();
                    registration.setName(name);
                    registration.setAge(age);
                    registration.setEmail(email);
                    registration.setPassword(password);
                    String query1 = "select * from users where email = '"  + registration.getEmail() + "'";
                    System.out.println( "query 1 = " + query1);
                    PreparedStatement st = con.prepareStatement(query1);
                    ResultSet rst = st.executeQuery(query1);
                    String emails;
                    if (rst.next()) {
                        emails = rst.getString("email");
//                        System.out.println("db email-->" + emails);
//                        System.out.println("input email-->" + registration.getEmail());
//                        System.out.println("comparing-->" + emails.equals(registration.getEmail()));
                        if (emails.equals(registration.getEmail())) {
                            return "user already exists";
                        }
                    }
                    else {
                        query = "insert into users (name,age,email,password) values (?,?,?,?)";
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, registration.getName());
                        pst.setInt(2, registration.getAge());
                        pst.setString(3, registration.getEmail());
                        pst.setString(4, registration.getPassword());
                        pst.executeUpdate();
                        return "welcome";
                    }
            } else {
                return "age should be positive";
            }
            return "error";
        }

    }
}
