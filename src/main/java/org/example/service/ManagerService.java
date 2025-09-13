package org.example.service;

import org.example.dao.LastBookingDAO;
import org.example.model.Booking;

import java.util.Scanner;

public class ManagerService {
    public static String validateBooking(int userId){
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
        return bookingState;
    }
}
