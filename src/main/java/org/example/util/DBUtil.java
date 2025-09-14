package org.example.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DBUtil {

    private static final Logger logger = LoggerFactory.getLogger(DBUtil.class);

    private static final String URL = "jdbc:postgresql://localhost:5432/restaurantmanager";
    private static final String USER = "sumitnegi";
    private static final String PASSWORD = "";

    private static DBUtil instance;
    private Connection connection;

    private DBUtil() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            logger.info("PostgreSQL connection established.");
        } catch (SQLException e) {
            logger.error("Error connecting to the database", e);
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
            logger.info("Connection re-established.");
        }
        catch (SQLException e){
            logger.error("Error reconnecting to the database", e);
            throw new RuntimeException("Error connecting to the datbase",e);
        }

    }
    public Connection getConnection() throws SQLException {
        if(connection.isClosed()){
            logger.info("Connection is closed or null, creating new connection.");
            createConnection();
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                logger.info("PostgreSQL connection closed.");
            }
        } catch (SQLException e) {
            logger.error("Error closing the connection", e);
        }
    }
}
