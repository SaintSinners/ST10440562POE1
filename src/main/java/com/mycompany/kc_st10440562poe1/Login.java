/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;
import java.util.*;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    //protect the login credentials
    private Map<String, String> user;
    private Map<String, String> password;
    private Map<String, String> userNames;
    private Scanner input;

    //make the variables accessible to the main program
    public Login() {
        this.user = new HashMap<>();
        this.password = new HashMap<>();
        this.userNames = new HashMap<>();
        this.input = new Scanner(System.in);
    }
    //The registration module
    public void registerUser() {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your surname: ");      
        String surname = input.nextLine();
        user.put(username,password);
        userNames.put (username, name + " " + surname);
        System.out.println("User, registered successfully! " + username);
    }
    //The Login Module
    public boolean loginUser(int loginAttempts) {
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        if (user.containsKey(username) && user.get(username).equals(password)) {
            String fullName = userNames.get(username);
            System.out.println("Login Successful! Welcome, " + fullName);
            loginAttempts = 0; 
        // Reset the counter on successful login
            return true;
        } else {
            // Increment the counter on failed login
            loginAttempts++; 
            System.out.println("Invalid username or password!");
            if (loginAttempts >= 5) {
                // Exit the program if login the attempts are beyond 5
                System.out.println("User is barred from the program.");
                System.exit(0); 
            }
            return false;           
    }
    }
    //Method called for display and Options at Start
    public void run() {
        //Using a while loop for the promting (No Limit on Attempts)
        while (true) {
            System.out.println("Welcome to the Login Menu");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            
            //Break line for clarity
            System.out.println("----------------------------------------------");
            System.out.print("Choose a number option from provided: ");
            
            //Allow user to insert a selection
            int option = Integer.parseInt(input.nextLine());
            switch (option) {
                case 1 -> registerUser();
                case 2 -> loginUser(0);
                case 3 -> { System.out.println("Goodbye!");
                
                        // Login successful, exit the loop
                        return;
                    }
                //if user selects bad options
                default -> System.out.println("Invalid option!");
            }
        }
    }

    public static void main(String[] args) {
        // This method should not be called directly
        // Instead, call the run method from the Login.java class
    }

}