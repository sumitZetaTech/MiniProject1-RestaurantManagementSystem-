package org.example.dao;

import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDishPriceDOA {
    private static final Logger logger = LoggerFactory.getLogger(UpdateDishPriceDOA.class);
    public void updateDishPrice(int dishId, int dishPrice){
        String query = "Update dishes set price = ?  where id = ?";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
//            System.out.println("dishPrice = "di);
            pstmt.setInt(1,dishPrice);
            pstmt.setInt(2,dishId);
            int rowAffected = pstmt.executeUpdate();
            if(rowAffected>0){
                logger.info("Dish price updated successfully: dishId={}, newPrice={}", dishId, dishPrice);
            }
            else{
                logger.warn("No dish found with dishId={} to update price", dishId);
            }

        } catch (SQLException e) {
            logger.error("Failed to update price for dishId={}, newPrice={}", dishId, dishPrice, e);
            throw new RuntimeException(e);
        }
    }
}
