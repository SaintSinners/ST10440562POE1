/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RC_Student_lab
 */
public class Login {
    //protect the login credentials
    private final Map<String, String> user;
    private final Map<String, String> passwords;
    private final Map<String, String> userNames;
    private final Scanner input;

    //make the variables accessible to the main program
    public Login() {
        this.user = new HashMap<>();
        this.passwords = new HashMap<>();
        this.userNames = new HashMap<>();
        this.input = new Scanner(System.in);
    }
    //The registration module
    public void registerUser() {
        //run a do while loop for accuracy of the username
        String username;
        do {
        System.out.print("Enter username (Must contain 5 characters + underscore): ");
        username = input.nextLine();
        } while (!CheckUsername(username));
        System.out.println("Enter Strong password (8 characters long, with a number, Capital letter & Special Character): ");
        String password = input.nextLine();
        
        //run a do while loop for accuracy of the password      
        do {
        } while (!checkPassword(password));

        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your surname: ");      
        String surname = input.nextLine();
        user.put(username,password);
        userNames.put (username, name + " " + surname);
        System.out.println("User, registered successfully! " + username);
    }
        //Check username
    public boolean CheckUsername(String username){
        //temp variable for checking
        boolean  Found;
        
        //Check the username
        if (username.contains("_") && username.length()==5){
            //then assign to true
            Found = true;
            //message output
            System.out.println("Username is successfully captured!");
        }else{
            //assign to false
            Found = false;
            System.out.println("Username must contain an underscore _ and be 5 Charactors long");
        }
        return Found;
    }
        //check the password
    public boolean checkPassword(String password){
        //pattern regex
        Pattern check_num = Pattern.compile("[0123456789]");
        Pattern ckeck_special = Pattern.compile("[!@#$%^&*-+_']");
        Pattern check_upper =Pattern.compile("[ABCDEFGHIJKLMNOPQRSTUVWXYZ]");
        
        // temp Variable for Found
        boolean Found;
        
        //check all here
        if(check_num.matcher(password).find() && ckeck_special.matcher(password).find() && check_upper.matcher(password).find()){
            
            //assign true
            Found = true;
            //Message
            System.out.println("Your Password was successfully captured!");
        } else{
            //assign false
            Found = false;
            //message
            System.out.println("Your Password must contain an integer, 8 characters, special character & a capital letter");
        }
        return Found;
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