package org.example.service;

import org.example.dao.LastBookingDAO;
import org.example.model.Booking;

public class ViewBooking {
    public static void viewBooking(int userId){
        LastBookingDAO lastBookingDAO = new LastBookingDAO();
        Booking booking = lastBookingDAO.getLatestBooking(userId);
        if(booking==null){
            System.out.println("You don't have any booking");
        }
        else{
            System.out.println("This is  your latest booking details");
            System.out.println("Your booking ID = "+booking.getId());
            System.out.println("Your booking Code = "+booking.getBookingCode());
            System.out.println("Your booking Status ="+booking.getBookingStatus());
            System.out.println("Please Note your booking table will be valid for the firt 15 minutes of booking!!!!!");
            System.out.println("Your booking time = "+booking.getBookingDatetime());
        }

    }
}
