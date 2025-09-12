package org.example.dao;

import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUserDAO {
    public boolean createUser(String role, String name, String email, String password){
        String insertQuery = "Inset into users (role, name , email, password ) values (?, ?, ?, ?)";
        DBUtil myDb = DBUtil.getInstance();
        try{
            Connection con = myDb.getConnection();
            PreparedStatement  pstmt = con.prepareStatement(insertQuery);
            pstmt.setString(1,role);
            pstmt.setString(2,name);
            pstmt.setString(3,email);
            pstmt.setString(4,password);
            pstmt.executeUpdate();
            System.out.println("User created succesfully");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("User created succesfully");
        return true;
    }
}
