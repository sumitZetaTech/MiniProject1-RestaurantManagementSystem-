package org.example.dao;

import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserExistDAO {
    private static final Logger logger = LoggerFactory.getLogger(UserExistDAO.class);
    public int checkUserExists(String email, String password, String role) {
        String sql = "SELECT id FROM users WHERE email = ? AND password = ? AND role = ?";
        DBUtil myDb = DBUtil.getInstance();
        logger.debug("Checking if user exists for email='{}' with role='{}'", email, role);
        try {
            Connection conn = myDb.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, role);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                logger.info("User found: email='{}', role='{}'", email, role);
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            logger.error("Error checking user existence for email='{}' and role='{}'", email, role, e);
            e.printStackTrace();
        }
        return -1;
    }
}
