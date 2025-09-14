package org.example.service;

import org.example.dao.BillDAO;
import org.example.dao.LastBookingDAO;
import org.example.dao.UpdateBookingStatusDAO;
import org.example.model.BillItem;
import org.example.model.Booking;
import org.example.model.Dish;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class ManagerService {
    public static Booking validateBooking(int userId){
        Scanner input = new Scanner(System.in);
        LastBookingDAO lastBookingDAO = new LastBookingDAO();
        Booking booking = lastBookingDAO.getLatestBooking(userId);
        System.out.println("Sir, Can you please share your booking Id");
        int bookingId = input.nextInt();
        System.out.println("Sir can you please share your booking code");
        int bookingCode = input.nextInt();
        String bookingState = booking.getBookingStatus();

        if(!(booking.getBookingCode()==bookingCode&&bookingId == booking.getId())){
            System.out.println("Your booking Id or Code is incorrect please verify and try again.");
        }

        if(bookingState.equals("Booked")){
            System.out.println("Welcome sir, your table is booked, i can see in my database");
        }
        else{
            System.out.println("I am extremely sorry sir, your booking is currently "+bookingState+" you need to book the table again");
        }
        // update booking status here ....................
        return booking;
    }
    public static void calculateBill(int bookingId){
        Scanner input = new Scanner(System.in);
        BillDAO billDAO = new BillDAO();
        List<BillItem> billItemList = billDAO.getDishWithTherePrice(bookingId);
        System.out.println("Hope you like our restaurant food, Sir!!");
        int totalBill = 0;
        for(BillItem billItem :billItemList){
            int price = billItem.getPrice();
            int quantity = billItem.getQuantity();
            totalBill += price*quantity;
            System.out.println(billItem.getName()+", price  ="+price+", quantity = "+quantity+", totalPrice = "+price*quantity);
        }
        System.out.println("Total Bill  = "+totalBill+" INR");

        boolean amountPaidCheck = false;

        while(!amountPaidCheck){
            System.out.println("Please enter the amount to pay successfully....");
            int userAmountPaid = input.nextInt();
            if(totalBill==userAmountPaid){
                System.out.println("Thank you sir, Received the transaction..");
                amountPaidCheck = true;
            }
            else if(userAmountPaid>totalBill){
                System.out.println("Sir you have overpayed, please have the rest of the amount = "+(userAmountPaid-totalBill));
                amountPaidCheck = true;
            }
            else{
                System.out.println("Sir you have underpayed, please pay the rest of the amount = "+(totalBill-userAmountPaid));
                totalBill -= userAmountPaid;
            }
        }
        UpdateBookingStatusDAO updateBookingStatusDAO = new UpdateBookingStatusDAO();
        updateBookingStatusDAO.updateTable("Used",bookingId);


    }
}
