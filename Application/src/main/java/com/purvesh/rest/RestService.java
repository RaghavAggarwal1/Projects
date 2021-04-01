package com.purvesh.rest;

import com.purvesh.app.LoginFlow;
import com.purvesh.app.ProductFlow;
import com.purvesh.app.RegistrationFlow;
import com.purvesh.app.SearchFlow;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/")
public class RestService {
    @GET // This annotation indicates GET request
    @Path("/login")
    public Response login(@QueryParam("id") String id, @QueryParam("pass") String pass) {
        String response = "";
        System.out.println(id);
        System.out.println(pass);
        try {
             response = LoginFlow.checkLogin(id, pass);
        } catch (SQLException throwables) {
            response = throwables.getMessage();
            return Response.status(404).entity(response).build();
        }
        return Response.status(200).entity(response).build();
    }

    @GET
    @Path("/register")
    public Response register(@QueryParam("name") String name, @QueryParam("age") String age, @QueryParam("email") String email, @QueryParam("pass") String pass ) {
        if(name.equals(null)) {
            return Response.status(200).entity("Invalid request parameters").build();
        }
        String response = "";
        String strRegEx = "^(?=.*[0-9]).{8,15}$";
        if(!pass.matches(strRegEx)) {
            return Response.status(200).entity("password doesnt match minimum criteria, which is" +
                    "1) Password must contain at least 8 characters\n" +
                    "2) Password must contain at least 1 number\n" +
                    "3) Password must contain at least 1 upper case letter\n" +
                    "4) Password must contain at least 1 lower case letter\n" +
                    "5) Password must contain at least 1 special character\n" +
                    "6) Password must not contain any spaces").build();
        }
        try{
            response = RegistrationFlow.getRegistration(name, age, email, pass);
        }catch (SQLException throwables) {
            response = throwables.getMessage();
            return Response.status(404).entity(response).build();
        }
        return Response.status(200).entity(response).build();
    }
    @GET // This annotation indicates GET request
    @Path("/Product")
    public Response Product(@QueryParam("ProductName") String productName, @QueryParam("Availability") boolean Availability, @QueryParam("description") String description, @QueryParam("Price") double price, @QueryParam("quantity") int quantity ) {
        String response = "";
        System.out.println(productName);
        System.out.println(Availability);
        System.out.println(description);
        System.out.println(price);
        System.out.println(quantity);
        try {
            response = ProductFlow.AddProduct(productName, Availability, description, price, quantity );
        } catch (SQLException throwables) {
            response = throwables.getMessage();
            return Response.status(404).entity(response).build();
        }
        return Response.status(200).entity(response).build();
    }

    @GET // This annotation indicates GET request
    @Path("/search")
    public Response Product(@QueryParam("q") String query ) {
        String response = "";
        System.out.println("query is" + query);
        try {
            response = SearchFlow.getProducts(query);
        } catch (SQLException throwables) {
            response = throwables.getMessage();
            return Response.status(404).entity(response).build();
        }
        return Response.status(200).entity(response).build();
    }

}