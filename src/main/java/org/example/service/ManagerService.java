package org.example.service;

import java.util.Scanner;

public class ManagerService {
    public static String validateBooking(){
        Scanner input = new Scanner(System.in);
        System.out.println("Sir, Can you please share your booking Id");
        int bookingId = input.nextInt();
        System.out.println("Sir can you please share your booking code");
        int bookingCode = input.nextInt();
        String bookingState = "Booked";
        if(bookingState.equals("Booked")){
            System.out.println("Welcome sir, your table is booked, i can see in my database");
        }
        else{
            System.out.println("I am extremely sorry sir, your booking is currently "+bookingState+" you need to book the table again");
        }
        return bookingState;
    }
}
