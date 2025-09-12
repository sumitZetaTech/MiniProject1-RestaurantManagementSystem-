package org.example.service;

import org.example.dao.DishDAO;
import org.example.model.Dish;

import java.util.List;
import java.util.Scanner;

public class WaiterService {
    List<Integer> order;
    public List<Integer> takeOrder(){
        Scanner sc = new Scanner(System.in);
        DishDAO dishDAO = new DishDAO();
        List<Dish>dishes = dishDAO.getAllDishes();
        System.out.println("Good Evening Sir, wanna check out our menu ?");
        System.out.println("Today's Menu");
        for(Dish dish: dishes){
            System.out.println(dish);
        }
        System.out.println("Please mention the number of the dish you want to order with the quantity space separated");
        while(true){
            int dishIndex;
            int quantity;
            dishIndex = sc.nextInt();
            if(dishIndex==-1){
                System.out.println("Thank you for the order our chef will prepare it with 15 mins....");
                break;
            }
            quantity = sc.nextInt();
            String dishName = dishes.get(dishIndex-1).getName();
            System.out.println(quantity+" "+dishName+" "+" added in the order do you want to add something else sir ?");
            System.out.println("Please mention the number of dish and the quantity or -1 if you want to complete this order");
        }
        System.out.println("May i take  your order request sir?");
        return order;
    }

}
