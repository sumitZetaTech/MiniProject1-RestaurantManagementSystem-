package org.example.dao;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExistDAO {
    public boolean checkUserExists(String email, String password, String role) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ? AND role = ?";
        DBUtil myDb = DBUtil.getInstance();
        try {
            Connection conn = myDb.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                int count = rs.getInt(1);
                return count>0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
