/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;
import java.util.*;
import javax.swing.*;
import java.util.regex.Pattern;

/**
 * word document added with notes
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
       private final int failedLogins = 0;    

    //make the variables accessible to the main program
    public Login() {
        this.user = new HashMap<>();
        this.password = new HashMap<>();
        this.userNames = new HashMap<>();
        this.input = new Scanner(System.in);
    }
    //Method to print account report
public void printAccountReport() {
    // Create a StringBuilder to build the report string
    StringBuilder report = new StringBuilder();
    
    // Add header for the report
    report.append("Account Report:\n");
    report.append("Registered Users:\n");
    
    // Loop through registered users and append to the report
    for (String username : userNames.keySet()) {
        report.append(username).append(": ").append(userNames.get(username)).append("\n");
    }
    
    // Append totals at the end of the report
    report.append("\nTotal Login Attempts: ").append(loginAttempts + successfulLogins + failedLogins).append("\n");
    report.append("Successful Logins: ").append(successfulLogins).append("\n");
    report.append("Failed Logins: ").append(failedLogins).append("\n");
    
    // Display the report using JOptionPane
    JOptionPane.showMessageDialog(null, report.toString(), "Account Report", JOptionPane.INFORMATION_MESSAGE);
}
    //The registration module
public void registerUser () {
    // Run a do-while loop for accuracy of the username
    String username;
    do {
        username = JOptionPane.showInputDialog("Enter username (Must contain 5 characters + underscore):");
        // If the user cancels the dialog, exit the method
        if (username == null) {
            JOptionPane.showMessageDialog(null, "Registration canceled.");
            return; // Exit the method if the user cancels
        }
    } while (!CheckUsername(username));

    // Request password
    // Run a do-while loop for accuracy of the password 
    String password;
    do {
        password = JOptionPane.showInputDialog("Enter Strong password (at least 8 characters long, with a number, capital letter & special character):");
        // If the user cancels the dialog, exit the method
        if (password == null) {
            JOptionPane.showMessageDialog(null, "Registration canceled.");
            return; // Exit the method if the user cancels
        }
    } while (!checkPasswordComplexity(password));

    // Request first name
    String firstName = JOptionPane.showInputDialog("Enter your first name:");
    // If the user cancels the dialog, exit the method
    if (firstName == null) {
        JOptionPane.showMessageDialog(null, "Registration canceled.");
        return; // Exit the method if the user cancels
    }

    // Request last name
    String lastName = JOptionPane.showInputDialog("Enter your last name:");
    // If the user cancels the dialog, exit the method
    if (lastName == null) {
        JOptionPane.showMessageDialog(null, "Registration canceled.");
        return; // Exit the method if the user cancels
    }

    // Store user information
    user.put(username, password);
    userNames.put(username, firstName + " " + lastName);
    JOptionPane.showMessageDialog(null, "User  registered successfully! " + username);
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
    public boolean checkPasswordComplexity(String password){
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
public String loginUser () {
    while (true) {
        // Prompt for username
        String username = JOptionPane.showInputDialog("Enter username:");
        // Check for cancellation
        if (username == null) {
            JOptionPane.showMessageDialog(null, "Login canceled.");
            return returnLoginStatus(false); // Exit if canceled
        }

        // Prompt for password
        String password = JOptionPane.showInputDialog("Enter password:");
        // Check for cancellation
        if (password == null) {
            JOptionPane.showMessageDialog(null, "Login canceled.");
            return returnLoginStatus(false); // Exit if canceled
        }

        // Check credentials
        if (user.containsKey(username) && user.get(username).equals(password)) {
            // Concatenate first name & last name
            String fullName = userNames.get(username);
            JOptionPane.showMessageDialog(null, "Welcome " + fullName + ", it is great to see you again.");
            successfulLogins++; // Increment successful logins
            return returnLoginStatus(true); // Return successful status
        } else {
            // Increment the counter on failed login
            loginAttempts++;
            JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again.");

            if (loginAttempts >= 5) {
                // Prompt user to try again or exit
                int response = JOptionPane.showConfirmDialog(null, "You have exceeded the maximum number of attempts. Do you want to try again?", "Max Attempts Exceeded", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    // Reset the counter and return to login
                    loginAttempts = 0;
                } else {
                    // End the program
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    return returnLoginStatus(false); // Return failed status
                }
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


    public static void main(String[] args) {
        // This method should not be called directly
        // Instead, call the run method from the Login.java class
    }

}