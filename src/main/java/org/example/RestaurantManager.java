package org.example;

import org.example.service.*;

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
        boolean exitHandleClientActivity = false;
        while(!exitHandleClientActivity) {
            System.out.println("Welcome to User page !!!!!");
            System.out.println("Please select the option you want to perform as a user enter the number with respect to the given option");
            System.out.println("1 -> Book ticket");
            System.out.println("2 -> Restaurant check in");
            System.out.println("3 -> Check your booking status,booking ID and Code");
            System.out.println("4 -> Exit the page");
            int myChoice = input.nextInt();
            switch (myChoice) {
                case 1:
                    BookingService.bookTable(userId);
                    break;
                case 2:
                    String bookingState = ManagerService.validateBooking(userId);
                    if (bookingState.equals("Booked")) {
                        WaiterService.takeOrder();
                    }
                    break;
                case 3:
                    ViewBooking.viewBooking(userId);
                    break;
                case 4:
                    System.out.println("Exiting the page ...");
                    exitHandleClientActivity = true;
                    break;
                default:
                    System.out.println("You have entered invalid option please try again");
                    break;
            }
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
