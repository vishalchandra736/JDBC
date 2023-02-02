package com.blz.assginment;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.Enumeration;
public class DataBaseConnector{
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "@123vishaL";
        //establish connection
        Connection connection = null;

        //driver is load or not
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find the driver in the classpath...", e);
        }
        listDrivers();
        //list all the driver
        try{
            System.out.println("connenting the database");
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connection is successful..."  + connection);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void listDrivers() {
        Enumeration<java.sql.Driver> listDrivers = DriverManager.getDrivers();

        while(listDrivers.hasMoreElements()) {
            Driver driverClass = (Driver) listDrivers.nextElement();
            System.out.println("" + driverClass.getClass().getName());
        }
    }
}


