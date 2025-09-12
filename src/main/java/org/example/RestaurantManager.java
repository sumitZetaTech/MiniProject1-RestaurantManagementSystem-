package org.example;

import org.example.dao.CreateUserDAO;
import org.example.service.CreateUser;
import org.example.service.LoginUser;

import java.util.Scanner;

public class RestaurantManager {
    private static RestaurantManager restaurantManager;
    private RestaurantManager(){

    }
    public static synchronized RestaurantManager getInstance(){
        if(restaurantManager==null){
            restaurantManager = new RestaurantManager();
        }
        return restaurantManager;
    }
    public void runApplication(){
        Scanner input = new Scanner(System.in);
        System.out.println("which operation you want to perform");
        System.out.println("1 -> Create user");
        System.out.println("2 -> Login as Client");
        System.out.println("3 -> Book as Admin");
        System.out.println("4 -> Other services");
        System.out.println("Please Enter your choice");
        while(true) {
            int myChoice = input.nextInt();
            switch (myChoice) {
                case 1:
                    CreateUser.createUser();
                    break;
                case 2:
                    LoginUser.loginUser("customer");
                    break;
                case 3:
                    LoginUser.loginUser("admin");
                    break;
                default:
                    System.out.println("Entered wrong number try again");

            }
        }
    }
}
