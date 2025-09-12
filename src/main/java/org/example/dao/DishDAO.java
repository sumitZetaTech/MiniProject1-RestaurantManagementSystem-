package org.example.dao;



import org.example.model.Dish;
import org.example.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {

    public List<Dish> getAllDishes() {
        List<Dish> dishes = new ArrayList<>();
        String query = "SELECT * FROM dishes ORDER BY id";
        DBUtil myDb = DBUtil.getInstance();

        try (Connection conn = myDb.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Dish dish = new Dish(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price")
                );
                dishes.add(dish);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dishes;
    }
}
