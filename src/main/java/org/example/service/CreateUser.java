package org.example.service;

import org.example.dao.CreateUserDAO;

import java.util.Scanner;

public class CreateUser {
    public static void createUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the user name");
        String name = input.nextLine();
        System.out.println("Please enter the emailId");
        String emailId = input.nextLine();
        System.out.println("Please enter the password for your account");
        String password = input.nextLine();
        CreateUserDAO createUserDAO = new CreateUserDAO();
        createUserDAO.createUser("customer",name,emailId,password);

    }
}
