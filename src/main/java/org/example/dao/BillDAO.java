package org.example.dao;

import org.example.model.BillItem;
import org.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    public List<BillItem> getDishWithTherePrice(int booking_id){
        String query = "Select dishes.name, orders.quantity, dishes.price from orders join dishes on orders.dish_id = dishes.id where booking_id = ?";
        List<BillItem>billItemList = new ArrayList<>();
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,booking_id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("checking booking id "+booking_id);

            while(rs.next()){
                String dishName = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                System.out.println("dishname = "+dishName+", quantity = "+quantity+" price = "+price);
                BillItem billItem = new BillItem(dishName,price,quantity);
                billItemList.add(billItem);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return billItemList;

    }
}
