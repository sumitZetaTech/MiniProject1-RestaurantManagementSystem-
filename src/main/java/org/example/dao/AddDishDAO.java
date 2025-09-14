package org.example.dao;

import org.example.model.Dish;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDishDAO {
    public void addDish(Dish dish){
        String addQuery = "Insert into dishes (name , price) values (?, ?)";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(addQuery);
            pstmt.setString(1,dish.getName());
            pstmt.setDouble(2,dish.getPrice());
            int rowsInserted = pstmt.executeUpdate();
            if(rowsInserted>0){
                System.out.println("Dish inserted successfully");
            }
            else{
                System.out.println("Failed to add Dish");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
