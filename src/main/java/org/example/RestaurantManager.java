package org.example;

import org.example.service.BookingService;
import org.example.service.CreateUser;
import org.example.service.LoginUser;
import org.example.service.WaiterService;

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
    public void handleClientActivity(int userId){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to User page !!!!!");
        System.out.println("Please select the option you want to perform as a user enter the number with respect to the given option");
        System.out.println("1 -> Book ticket");
        System.out.println("2 -> Restaurant check in");
        int myChoice = input.nextInt();
        switch (myChoice){
            case 1:
                BookingService.bookTable(userId);
                break;
            case 2:
                System.out.println("Restaurant service");
                break;
            case 3:
                System.out.println("You have entered invalid option please try again");
                break;

        }

    }
    public void applicationAuth(){
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
                    int userId = LoginUser.loginUser("customer");
                    handleClientActivity(userId);
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
