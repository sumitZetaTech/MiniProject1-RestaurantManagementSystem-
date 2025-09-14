package org.example.dao;

import org.example.model.Booking;
import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LastBookingDAO {
    private static final Logger logger = LoggerFactory.getLogger(LastBookingDAO.class);
    public Booking getLatestBooking(int userId) {
        String sql = "SELECT * FROM bookings WHERE user_id = ? ORDER BY booking_datetime DESC LIMIT 1";
        Booking booking = null;

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            logger.debug("Fetching latest booking for userId={}", userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    booking = new Booking(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("booking_code"),
                            rs.getString("booking_status"),
                            rs.getTimestamp("booking_datetime")
                    );
                    logger.info("Latest booking found: bookingId={}, userId={}", booking.getId(), userId);
                }
                else{
                    logger.info("No booking found for userId={}", userId);
                }
            }

        } catch (SQLException e) {
            logger.error("SQL error while fetching latest booking for userId={}", userId, e);
            throw new RuntimeException("Error fetching latest booking", e);
        }

        return booking;
    }

}
