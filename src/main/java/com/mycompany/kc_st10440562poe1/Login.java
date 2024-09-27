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
    private final Map<String, String> password;
    private final Map<String, String> userNames;
    private final Scanner input;
    //Initialize counter variables
       private int loginAttempts;
       private int successfulLogins = 0;
       private int failedLogins = 0;    

    //make the variables accessible to the main program
    public Login() {
        this.user = new HashMap<>();
        this.password = new HashMap<>();
        this.userNames = new HashMap<>();
        this.input = new Scanner(System.in);
    }
    //Method to print account report
    public void printAccountReport() {
        System.out.println("Account Report:");
        System.out.println("Registered Users:");
        for (String username : userNames.keySet()) {
            System.out.println(username + ": " + userNames.get(username));
        }
        //Print Results at the end of the program
        System.out.println("Total Login Attempts: " + (loginAttempts + successfulLogins + failedLogins));
        System.out.println("Successful Logins: " + successfulLogins);
        System.out.println("Failed Logins: " + failedLogins);
    }
    //The registration module
    public void registerUser() {
        //run a do while loop for accuracy of the username
        String username;
        do {
        System.out.print("Enter username (Must contain 5 characters + underscore): ");
        username = input.nextLine();
        } while (!CheckUsername(username));
        //request password
        //run a do while loop for accuracy of the password 
        String password;
        do {
        System.out.println("Enter Strong password (at least 8 characters long, with a number, Capital letter & Special Character): ");
        password = input.nextLine();
        } while (!checkPassword(password));

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter your last name: ");      
        String lastName = input.nextLine();
        user.put(username, password);
        userNames.put (username, firstName + " " + lastName);
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
            System.out.println("Username successfully captured!");
        }else{
            //assign to false
            Found = false;
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscoreand is no more tha 5 characters in length");
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
            System.out.println("Password successfully captured!");
        } else{
            //assign false
            Found = false;
            //message
            System.out.println("Password is not correctly formatted, Please ensure that your password contains atleast 8 characters, a capital letter, a number and a special character");
        }
        return Found;
    }
    //The Login Module
    public String loginUser() {
        while (true){
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        if (user.containsKey(username) && user.get(username).equals(password)) {
            //concagtinate first name  & last name
            String fullName = userNames.get(username);
            System.out.println("Welcome " + fullName +", it is great to see you again");
        //Send report for attempts            
            successfulLogins++; 
        // Reset the counter on successful login
            return returnLoginStatus(true);
        } else {
            // Increment the counter on failed login
            loginAttempts++; 
            System.out.println("Username or password incorrect, please try again");
            if (loginAttempts >= 5) {
                //Propt user to try again or Exit
                System.out.println("You have exceed the maximum number of attempts");
                System.out.println("input yes or no to continue");
                String response = input.nextLine();
                if (response.equalsIgnoreCase("yes")){
                    //Reset the counter and return to main method
                    loginAttempts = 0;
                }
            }else {
            //End the program
            System.out.println("Goodbye");
            return returnLoginStatus(false);           
            }
            }
        }
    }
    //Method to return the login status post attempts
    public String returnLoginStatus(boolean loginStatus) {
    if (loginStatus) {
        return "Successful Login";
    } else {
        return "Failed Login";
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
                case 2 -> { String loginStatus = loginUser();
                System.out.println(loginStatus);
                if (loginStatus.equals("Successful Login")) {
                    System.out.println("You are now logged in.");
                } else {
                    System.out.println("Login failed. Please try again.");
                }
            }
                case 3 -> { 
                    printAccountReport();
                    System.out.println("Goodbye!");
                
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