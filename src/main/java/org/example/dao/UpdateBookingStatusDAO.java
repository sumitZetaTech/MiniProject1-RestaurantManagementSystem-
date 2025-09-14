package org.example.dao;

import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBookingStatusDAO {
    private static final Logger logger = LoggerFactory.getLogger(UpdateBookingStatusDAO.class);
    public void updateTable(String newStatus,int bookingId){
        String query = "update bookings set booking_status = ? where id = ?";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,newStatus);
            pstmt.setInt(2,bookingId);
            pstmt.executeUpdate();
            logger.info("Booking status updated to '{}' for bookingId={}", newStatus, bookingId);

        } catch (SQLException e) {
            logger.error("Failed to update booking status for bookingId={} to '{}'", bookingId, newStatus, e);
            throw new RuntimeException(e);
        }
    }
}
