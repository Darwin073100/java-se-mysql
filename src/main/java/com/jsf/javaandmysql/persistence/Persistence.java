package com.jsf.javaandmysql.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author edwin
 */
public class Persistence {
    private final String URL = "jdbc:mysql://localhost:3306/crud_db";
    private final String USER = "root";
    private final String PASSWORD = "admin123";
    
    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            if(connection != null){
                System.out.println("Connection Correct");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
