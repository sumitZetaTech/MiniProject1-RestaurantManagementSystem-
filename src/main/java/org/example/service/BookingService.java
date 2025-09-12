package org.example.service;

import org.example.dao.AvailableTableDAO;
import org.example.dao.BookingDAO;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class BookingService {
    Scanner input = new Scanner(System.in);
    int generateFourDigitCode(){
        int randomNumber = 0;
        Random random = new Random();
        for(int curDigit = 1;curDigit<=4;curDigit++){
            randomNumber = randomNumber*10+random.nextInt(10);
        }
        return randomNumber;
    }
    void bookTable(int userId){
        BookingDAO bookingDAO = new BookingDAO();
        Scanner input = new Scanner(System.in);
        System.out.println("Let me check the availability");
        AvailableTableDAO availableTableDAO = new AvailableTableDAO();
        int tableAvailable = availableTableDAO.availableTableCount();
        if(tableAvailable<=0){
            System.out.println("No tables are available right now please wait and try booking after 5-10 minutes later");
            return;
        }

        System.out.println("Tables are available please type 'yes' to book a table");
        String userDecision = input.nextLine();
        if(!Objects.equals(userDecision, "yes"))return;
        System.out.println("Your table has been booked please visit the restaurant within 15 minutes else your booking would be canceled");

        bookingDAO.insertBooking(userId,generateFourDigitCode());


    }
}
