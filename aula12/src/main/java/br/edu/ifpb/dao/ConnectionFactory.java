package br.edu.ifpb.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    
    public Connection getConnection(String url, String username, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception exception) {
            exception.printStackTrace();
            throw new RuntimeException();
        }
    }
}
