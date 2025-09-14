package org.example.dao;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveDishDOA {
    public void removeDish(int dishId){
        String query = "Delete from dishes where id = ?";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            int rowDeleted = pstmt.executeUpdate();
            if(rowDeleted>0){
                System.out.println("Dish removed succesfully");
            }
            else{
                System.out.println("No dish found");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
