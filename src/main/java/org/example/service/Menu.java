package org.example.service;

import org.example.dao.DishDAO;
import org.example.model.Dish;

import java.util.List;

public class Menu {
    public static void showMenu(){
        DishDAO dishDAO = new DishDAO();
        List<Dish> dishes = dishDAO.getAllDishes();
        System.out.println("Today's Menu");
        for(Dish dish: dishes){
            System.out.println(dish);
        }
    }
}
