package org.example.dao;

import org.example.model.DailySales;
import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DailySalesDOA {
    private static final Logger logger = LoggerFactory.getLogger(DailySalesDOA.class);
    public List<DailySales> getDailySales(){
        List<DailySales> dailySales = new ArrayList<>();
        String query  = "SELECT " +
                "    orders.booking_id, " +
                "    (dishes.price * orders.quantity) AS totalPrice " +
                "FROM  " +
                "    orders " +
                "JOIN  " +
                "    bookings ON orders.booking_id = bookings.id " +
                "JOIN  " +
                "    dishes ON orders.dish_id = dishes.id " +
                "WHERE " +
                "    DATE(bookings.booking_datetime) = CURRENT_DATE;";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs =  pstmt.executeQuery();
            logger.debug("Executing daily sales query");
            while(rs.next()){
                int bookingId = rs.getInt("booking_id");
                int totalPrice = rs.getInt("totalPrice");
                DailySales dailySale = new DailySales(bookingId,totalPrice);
                dailySales.add(dailySale);
                logger.debug("Fetched sale - Booking ID: {}, Total Price: {}", bookingId, totalPrice);
            }
            logger.info("Total daily sales records fetched: {}", dailySales.size());

        } catch (SQLException e) {
            logger.error("Error fetching daily sales", e);
            throw new RuntimeException(e);
        }
        return dailySales;
    }
}
