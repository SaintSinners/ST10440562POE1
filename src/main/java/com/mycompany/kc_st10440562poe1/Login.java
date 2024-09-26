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
    private Map<String, String> users;
    private Map<String, String> password;
    private Scanner scanner;

    //make the variables accessible to the main program
    public Login() {
        this.users = new HashMap<>();
        this.password = new HashMap<>();
        this.scanner = new Scanner(System.in);
    }
    //The registration module
    public void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("User registered successfully!");
    }
    //The Login Module
    public boolean loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Invalid username or password!");
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
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1 -> registerUser();
                case 2 -> loginUser();
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