package com.bhagya.practice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {

    public Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:mysql://localhost:3306/AirlineTicketInfo";
            String username = "root";
            String password = "shri@8994";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }
}

