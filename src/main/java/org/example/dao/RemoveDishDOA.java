package org.example.dao;

import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveDishDOA {
    private static final Logger logger = LoggerFactory.getLogger(RemoveDishDOA.class);

    public void removeDish(int dishId){
        String query = "Delete from dishes where id = ?";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,dishId);
            int rowDeleted = pstmt.executeUpdate();
            if(rowDeleted>0){
                logger.info("Dish removed successfully: dishId={}", dishId);
            }
            else{
                logger.warn("No dish found with dishId={}", dishId);
            }

        } catch (SQLException e) {
            logger.error("Error removing dish with dishId={}", dishId, e);
            throw new RuntimeException(e);
        }

    }
}
