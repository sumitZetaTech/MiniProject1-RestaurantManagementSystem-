package org.example.util;

import java.sql.*;

public class DBUtil {

    private static final String URL = "jdbc:postgresql://localhost:5432/restaurantmanager";
    private static final String USER = "sumitnegi";
    private static final String PASSWORD = "";

    private static DBUtil instance;
    private Connection connection;

    private DBUtil() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("PostgreSQL connection established.");
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public static synchronized DBUtil getInstance() {
        if (instance == null) {
            instance = new DBUtil();
        }
        return instance;
    }

    public void createConnection(){
        try{
            this.connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Connection re-established");
        }
        catch (SQLException e){
            throw new RuntimeException("Error connecting to the datbase",e);
        }

    }
    public Connection getConnection() throws SQLException {
        if(connection.isClosed()){
            createConnection();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("PostgreSQL connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
