package com.purvesh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductFlow {
    public static String AddProduct(String productName,boolean Availability,String description, double price, int quantity ) throws SQLException{
        Connection con = SqlConnector.getConnection();
        String query = null ;
        Product product = new Product();
        product.setProductName(productName);
        product.setAvailability(Availability);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        query = "insert into product (productName,availability,description,price,quantity) values (?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, product.getProductName());
        pst.setBoolean(2, product.isAvailability());
        pst.setString(3, product.getDescription());
        pst.setDouble(4, product.getPrice());
        pst.setInt(5, product.getQuantity());
        pst.executeUpdate();

        return " you can see all the products ";
    }
}
