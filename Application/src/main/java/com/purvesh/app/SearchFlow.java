package com.purvesh.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SearchFlow {
    public static String getProducts(String query)throws SQLException {
        Set<String> set = massageQuery(query);
        Connection con = SqlConnector.getConnection();
        System.out.println("search product ");
        String q = generateQuery(set);
        //q = "Select * from product WHERE  ProductName '% " + ProductName  + " % ' ";
        PreparedStatement pst = con.prepareStatement(q);
        ResultSet rt = pst.executeQuery(q);
        ArrayList<String> al = new ArrayList<>();
        while(rt.next()) {
            al.add(rt.getString(2).toString());
        }
        String val = "";
        for (String s : al)
        {
            val += s + "\t";
        }
        return val;
    }

    private static String generateQuery(Set<String> set) {

        StringBuilder sb = new StringBuilder();
        sb.append("Select * from product WHERE ");
        for(String str: set) {
            sb.append("productName LIKE '%").append(str).append("%'").append(" OR ");
        }
        sb.setLength(sb.length() - 4);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static Set<String> massageQuery(String query) {
        Set<String> set = new HashSet<>();
        set.add(query);
        System.out.println(query);
        String[] arr = query.split("\\s*,\\s*");
        System.out.println(arr.length);
        set.addAll(Arrays.asList(arr));
        return set;
    }
}
