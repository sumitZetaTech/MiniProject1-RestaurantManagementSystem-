package org.example.service;

import org.example.dao.AvailableTableDAO;

import java.util.Objects;
import java.util.Scanner;

public class BookingService {
    Scanner input = new Scanner(System.in);
    void bookTable(int userId){
        Scanner input = new Scanner(System.in);
        System.out.println("Let me check the availability");
        AvailableTableDAO availableTableDAO = new AvailableTableDAO();
        int tableAvailable = availableTableDAO.availableTableCount();
        if(tableAvailable<=0){
            System.out.println("No tables are available right now please wait and try booking after 5-10 minutes later");
            return;
        }
        else{
            System.out.println("Tables are available please type 'yes' to book a table");
            String userDecision = input.nextLine();
            if(!Objects.equals(userDecision, "yes"))return;
            System.out.println("Your table has been booked please visit the restaurant within 15 minutes else your booking would be canceled");



        }
    }
}
