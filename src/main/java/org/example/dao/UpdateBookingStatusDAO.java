package org.example.dao;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBookingStatusDAO {
    public void updateTable(String newStatus,int booking_id){
        String query = "update bookings set booking_status = ? where id = ?";
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,newStatus);
            pstmt.setInt(2,booking_id);
            pstmt.executeUpdate();
            System.out.println("Status updated successfully to "+newStatus +"for "+booking_id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
