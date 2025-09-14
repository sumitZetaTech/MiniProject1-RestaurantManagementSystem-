package org.example.dao;



import org.example.model.Dish;
import org.example.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {

    private static final Logger logger = LoggerFactory.getLogger(DishDAO.class);
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
                logger.debug("Fetched dish: id={}, name={}, price={}", dish.getId(), dish.getName(), dish.getPrice());
                dishes.add(dish);
            }
            logger.info("Total dishes fetched: {}", dishes.size());

        } catch (SQLException e) {
            logger.error("Failed to fetch dishes from database", e);
        }

        return dishes;
    }
}
