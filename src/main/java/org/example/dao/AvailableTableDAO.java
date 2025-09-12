package org.example.dao;

import org.example.model.Dish;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AvailableTableDAO {
    final int tableInRestaurant = 20;
    public int availableTableCount() {

        String updateTableQuery = "UPDATE bookings SET booking_status = 'Canceled' WHERE booking_status = 'Booked' AND booking_datetime <= NOW() - INTERVAL '15 minutes'";
        String countQuery = "SELECT COUNT(*) AS active_or_booked_count FROM bookings WHERE booking_status IN ('Booked', 'Active')";
        DBUtil myDb = DBUtil.getInstance();
        int occupiedTableCount = 0;

        try {
        Connection conn = myDb.getConnection();
             Statement stmt = conn.createStatement();
             stmt.executeUpdate(updateTableQuery);
             ResultSet rs = stmt.executeQuery(countQuery);
             if(rs.next()){
                 occupiedTableCount = rs.getInt("active_or_booked_count");
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableInRestaurant-occupiedTableCount;
    }

}
