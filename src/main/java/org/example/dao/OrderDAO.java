package org.example.dao;

import org.example.model.Order;
import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO {
    private static final Logger logger = LoggerFactory.getLogger(OrderDAO.class);
    public void insertOrders(List<Order> orders,int bookingId){
        String sql = "Insert into orders (booking_id, dish_id, quantity) values (?, ?, ?)";
        DBUtil myDb = DBUtil.getInstance();
        try {
            Connection conn = myDb.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (Order order : orders) {
                pstmt.setInt(1, bookingId);
                pstmt.setInt(2, order.getDishId());
                pstmt.setInt(3, order.getDishCount()); // Can be current timestamp or passed in

                pstmt.addBatch(); // Add to batch
                logger.debug("Prepared order: bookingId={}, dishId={}, quantity={}", bookingId, order.getDishId(), order.getDishCount());
            }

            pstmt.executeBatch(); // Execute all inserts at once
            logger.info("Inserted {} orders for bookingId={}", orders.size(), bookingId);

        } catch (SQLException e) {
            logger.error("Failed to insert orders for bookingId={}", bookingId, e);
            throw new RuntimeException(e);
        }

    }
}
