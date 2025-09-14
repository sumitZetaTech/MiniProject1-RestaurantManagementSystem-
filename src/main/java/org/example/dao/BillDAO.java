package org.example.dao;

import org.example.model.BillItem;
import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private static final Logger logger = LoggerFactory.getLogger(BillDAO.class);
    public List<BillItem> getDishWithTherePrice(int bookingId){
        String query = "Select dishes.name, orders.quantity, dishes.price from orders join dishes on orders.dish_id = dishes.id where booking_id = ?";
        List<BillItem>billItemList = new ArrayList<>();
        try{
            Connection conn = DBUtil.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,bookingId);
            ResultSet rs = pstmt.executeQuery();
            logger.debug("Fetching bill items for booking ID: {}", bookingId);

            while(rs.next()){
                String dishName = rs.getString("name");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                System.out.println("dishname = "+dishName+", quantity = "+quantity+" price = "+price);
                BillItem billItem = new BillItem(dishName,price,quantity);
                billItemList.add(billItem);
                logger.debug("Fetched dish: {}, quantity: {}, price: {}", dishName, quantity, price);
            }
        } catch (SQLException e) {
            logger.error("Failed to fetch bill items for booking ID: {}", bookingId, e);
            throw new RuntimeException(e);
        }
        return billItemList;

    }
}
