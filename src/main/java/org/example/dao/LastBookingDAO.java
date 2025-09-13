package org.example.dao;

import org.example.model.Booking;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LastBookingDAO {
    public Booking getLatestBooking(int userId) {
        String sql = "SELECT * FROM bookings WHERE user_id = ? ORDER BY booking_datetime DESC LIMIT 1";
        Booking booking = null;

        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    booking = new Booking(
                            rs.getInt("id"),
                            rs.getInt("user_id"),
                            rs.getInt("booking_code"),
                            rs.getString("booking_status"),
                            rs.getTimestamp("booking_datetime")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error fetching latest booking", e);
        }

        return booking;
    }

}
