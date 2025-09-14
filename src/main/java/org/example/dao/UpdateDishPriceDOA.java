package org.example.dao;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDishPriceDOA {
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
                System.out.println("Price updated successfully");
            }
            else{
                System.out.println("No dish found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
