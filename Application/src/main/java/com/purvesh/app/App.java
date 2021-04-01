package com.purvesh.app;
import java.sql.*;

public class App {
    public static void main(String[] args) throws SQLException {
            Connection con = SqlConnector.getConnection();
            String query = null;
          if(args[0].equals("addProduct") ){
                System.out.println(" you can see our products ");
                Product product = new Product();
                String productName = args[1];
                boolean availability = Boolean.parseBoolean(args[2]);
                String description =  args[3];
                double price = Double.parseDouble(args[4]);
                product.setProductName(productName);
                product.setAvailability(availability);
                product.setDescription(description);
                product.setPrice(price);
                query = "insert into product (productName,availability,description,price) values (?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, product.getProductName());
                pst.setBoolean(2, product.isAvailability());
                pst.setString(3, product.getDescription());
                pst.setDouble(4, product.getPrice());
                pst.executeUpdate();
            }
            else {
                System.out.println("please try again");

            }


    }

}
