package org.example.service;

import org.example.RestaurantManager;
import org.example.dao.AddDishDAO;
import org.example.dao.DailySalesDOA;
import org.example.dao.RemoveDishDOA;
import org.example.dao.UpdateDishPriceDOA;
import org.example.model.DailySales;
import org.example.model.Dish;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    public void addDish(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the dish name");
        String dishName = input.nextLine();
        System.out.println("Enter the dish price");
        int dishPrice = input.nextInt();
        Dish dish = new Dish(1,dishName,dishPrice);
        AddDishDAO addDishDAO = new AddDishDAO();
        addDishDAO.addDish(dish);
    }

    public void deleteDish(){
        Scanner input = new Scanner(System.in);
        System.out.println("Which dish you want to remove, please enter the dish id");
        Menu.showMenu();
        int dishId = input.nextInt();
        RemoveDishDOA removeDishDOA = new RemoveDishDOA();
        removeDishDOA.removeDish(dishId);
    }

    public void updatePrice(){
        Scanner input = new Scanner(System.in);
        Menu.showMenu();
        System.out.println("Which dish price you want to update, please enter the dish id ");
        int dishId = input.nextInt();
        System.out.println("Please enter the new price for the dish");
        int updatedPrice = input.nextInt();
        UpdateDishPriceDOA updateDishPriceDOA = new UpdateDishPriceDOA();
        updateDishPriceDOA.updateDishPrice(dishId,updatedPrice);
    }

    public void checkDailySales(){
        DailySalesDOA dailySalesDOA = new DailySalesDOA();
        List<DailySales> dailySales= dailySalesDOA.getDailySales();
        int grandTotal = 0;
        for(DailySales dailySale : dailySales){
            System.out.println("BookingId = "+dailySale.getBookingId()+", Amount Paid = "+dailySale.getAmountPaid());
            grandTotal += dailySale.getAmountPaid();
        }
        System.out.println("Grand Total for the day = "+grandTotal);
    }

}
