package org.example.dao;

import org.example.model.Order;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO {
    public void insertOrders(List<Order> orders){
        String sql = "Insert into orders (booking_id, dish_id, quantity) values (?, ?, ?)";
        DBUtil myDb = DBUtil.getInstance();
        try {
            Connection conn = myDb.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (Order order : orders) {
//                pstmt.setInt(1, order.getUserId());
                pstmt.setInt(2, order.getDishId());
                pstmt.setInt(3, order.getDishCount()); // Can be current timestamp or passed in

                pstmt.addBatch(); // Add to batch
            }

            pstmt.executeBatch(); // Execute all inserts at once
            System.out.println("All orders inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
