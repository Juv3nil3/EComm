package com.example.ecommerce;

import java.sql.ResultSet;

public class Login {
    public Customer customerLogin(String username, String password){
        String loginQuery = "SELECT * FROM customer WHERE email = '"+username+"'AND password ='" + password+"'";
        DbConnection conn = new DbConnection();
        ResultSet rs = conn.getQueryTable(loginQuery);
        try{
            if (rs.next()){
               return new Customer(rs.getInt("id"), rs.getString("name"),
                       rs.getString("email"), rs.getString("mobile"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Login login = new Login();
        Customer customer = login.customerLogin("juv@gmail.com", "wowpass");
        System.out.println("Welcome: "+ customer.getName());
    }
}
