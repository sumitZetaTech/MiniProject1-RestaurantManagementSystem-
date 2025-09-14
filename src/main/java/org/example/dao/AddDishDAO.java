package org.example.dao;

import org.example.model.Dish;
import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDishDAO {
    private static final Logger logger = LoggerFactory.getLogger(AddDishDAO.class);
    public void addDish(Dish dish){

        String addQuery = "Insert into dishes (name , price) values (?, ?)";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(addQuery);
            pstmt.setString(1,dish.getName());
            pstmt.setDouble(2,dish.getPrice());
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted>0){
                logger.info("Dish inserted successfully: {}", dish.getName());
            }
            else{
                logger.warn("Dish insertion failed for: {}", dish.getName());
            }

        } catch (SQLException e) {
            logger.error("SQL exception occurred while inserting dish: {}", dish, e);
            throw new RuntimeException(e);
        }

    }
}
