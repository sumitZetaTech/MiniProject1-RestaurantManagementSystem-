package org.example.dao;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class BookingDAO {

    public void insertBooking(int userId, int bookingCode) {
        String insertQuery = "INSERT INTO bookings (user_id, booking_code, booking_status, booking_datetime) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, bookingCode);
            pstmt.setString(3, "Booked");
            pstmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now())); // Converts LocalDateTime to SQL Timestamp

            pstmt.executeUpdate();

            System.out.println("Booking inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}