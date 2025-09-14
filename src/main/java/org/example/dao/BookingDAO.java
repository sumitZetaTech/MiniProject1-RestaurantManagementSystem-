package org.example.dao;

import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BookingDAO {
    private static final Logger logger = LoggerFactory.getLogger(BookingDAO.class);

    public void insertBooking(int userId, int bookingCode) {
        String insertQuery = "INSERT INTO bookings (user_id, booking_code, booking_status, booking_datetime) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, bookingCode);
            pstmt.setString(3, "Booked");
            pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now())); // Converts LocalDateTime to SQL Timestamp

            pstmt.executeUpdate();
            logger.info("Booking inserted successfully: userId={}, bookingCode={}", userId, bookingCode);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Error inserting booking for userId={}, bookingCode={}", userId, bookingCode, e);
        }
    }
}