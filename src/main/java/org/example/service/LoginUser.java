package org.example.service;


import org.example.dao.UserExistDAO;

import java.util.Scanner;

public class LoginUser {
    public static int loginUser(String user){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Please enter your email");
            String email = input.nextLine();
            System.out.println("Please enter your password");
            String password = input.nextLine();

            UserExistDAO userExistDAO = new UserExistDAO();
            int userId = userExistDAO.checkUserExists(email,password,user);
            if(userId>0){
                System.out.println("Login successfull");
            }
            else{
                System.out.println("wrong password or email please try again");
            }
            return userId;
        }

    }
}
