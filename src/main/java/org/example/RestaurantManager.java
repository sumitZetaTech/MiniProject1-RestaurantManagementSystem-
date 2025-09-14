package org.example;

import org.example.model.Booking;
import org.example.model.Order;
import org.example.service.*;

import java.util.List;
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
    // handleClientActivity...
    public void customerRestaurantActivity(int userId){
        Scanner input = new Scanner(System.in);
        Booking booking = ManagerService.validateBooking(userId);
        if (!booking.getBookingStatus().equals("Booked")) return ;
        boolean restaurantExit = false;
        System.out.println(booking.getId()+ " = bookingId");
        while(!restaurantExit){
            System.out.println("Welcome to Romeo Restaurant");
            System.out.println("Please enter 1, for ordering dish");
            System.out.println("Please enter 2, for checking out from restaurant");
            int userRequest = input.nextInt();
            switch (userRequest){
                case 1 :
                    WaiterService.takeOrder(booking.getId());
                    break;
                case 2 :
                    System.out.println("Calling restaurant manager");
                    ManagerService.calculateBill(booking.getId());
                    restaurantExit = true;
                    break;
                default:
                    System.out.println("Invalid entry please try again");
                    break;
            }

        }


        List<Order>myOrders = WaiterService.takeOrder(userId);

        // will write some logic here
    }
    public void customerHomePage(int userId){
        Scanner input = new Scanner(System.in);
        boolean exitHandleClientActivity = false;
        while(!exitHandleClientActivity) {
            System.out.println("Welcome to User page !!!!!");
            System.out.println("Please select the option you want to perform as a user enter the number with respect to the given option");
            System.out.println("1 -> Book table");
            System.out.println("2 -> Restaurant check in");
            System.out.println("3 -> Check your booking status,booking ID and Code");
            System.out.println("4 -> Exit the page");
            int myChoice = input.nextInt();
            switch (myChoice) {
                case 1:
                    BookingService.bookTable(userId);
                    break;
                case 2:
                    customerRestaurantActivity(userId);
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
    public void adminHomePage(){
        Scanner input = new Scanner(System.in);
        boolean existAdminHomePage = false;
        Admin admin = new Admin();
        while(!existAdminHomePage) {
            System.out.println("Please enter the operation you want to perform out of the following....");
            System.out.println("1 -> Add a new dish in table");
            System.out.println("2 -> Delete a dish from the table");
            System.out.println("3 -> Update the price of a dish in the table");
            System.out.println("4 -> Check today's sale");
            System.out.println("5 -> Exit home page");
            int adminRequest = input.nextInt();
            switch (adminRequest){
                case 1 : admin.addDish();
                    break;
                case 2 : admin.deleteDish();
                    break;
                case 3 : admin.updatePrice();
                    break;
                case 4 : admin.checkDailySales();
                    break;
                case 5 : existAdminHomePage = true;
                    break;
                default :
                    System.out.println("You have entered wrong option please try again");
            }
        }

    }
    public void applicationAuth(){
        Scanner input = new Scanner(System.in);
        System.out.println("which operation you want to perform");
        System.out.println("1 -> Create user");
        System.out.println("2 -> Login as Client");
        System.out.println("3 -> Login as Admin");
        System.out.println("Please Enter your choice");
        while(true) {
            int myChoice = input.nextInt();
            switch (myChoice) {
                case 1:
                    CreateUser.createUser();
                    break;
                case 2:
                    int userId = LoginUser.loginUser("customer");
                    customerHomePage(userId);
                    break;
                case 3:
                    LoginUser.loginUser("admin");
                    adminHomePage();
                    break;
                default:
                    System.out.println("Entered wrong number try again");

            }
        }
    }
}
