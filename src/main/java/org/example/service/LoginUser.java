package org.example.service;


import org.example.dao.UserExistDAO;

import java.util.Scanner;

public class LoginUser {
    public static void loginUser(String user){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Please enter your email");
            String email = input.nextLine();
            System.out.println("Please enter your password");
            String password = input.nextLine();

            UserExistDAO userExistDAO = new UserExistDAO();
            if(userExistDAO.checkUserExists(email,password,user)){
                System.out.println("Login successfully");
                break;
            }
            else{
                System.out.println("Wrong password or email please try again");
            }
        }

    }
}
