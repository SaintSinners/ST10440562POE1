/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kc_st10440562poe1;
import javax.swing.*;

/**
 *
 * @author RC_Student_lab
 */
public class KC_ST10440562POE1 {
    

    public static void main(String[] args) {
        //Object of a class called for the Login applicatin
            run program = new run();
    }
        private static class run {

        public run() {// Using a while loop for the prompting (No Limit on Attempts)
            Login login = new Login();
    while (true) {
        // Display welcome message and options
        String message = """
                         Welcome to the Login Menu
                         1. Register
                         2. Login
                         3. Exit
                         -------------------------------------------------------""";
        String optionString = JOptionPane.showInputDialog(message + "\nChoose a number option from provided:");

        // Check if the user clicked "Cancel" or closed the dialog
        if (optionString == null) {
            JOptionPane.showMessageDialog(null, "Goodbye!");
            return; // Exit the loop if the user cancels
        }

        // Convert the input to an integer
        int option;
        try {
            option = Integer.parseInt(optionString);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
            continue; // Restart the loop
        }

        switch (option) {
            case 1 -> login.registerUser();
            case 2 -> {
                String loginStatus = login.loginUser();
                JOptionPane.showMessageDialog(null, loginStatus);
                if (loginStatus.equals("Successful Login")) {
                    JOptionPane.showMessageDialog(null, "You are now logged in.");
                    
                    // Display the EasyKanban menu
                    while (true) {
                        String easyKanbanMenu = """
                                                Welcome to EasyKanban
                                                1. Add task
                                                2. Show Report
                                                3. Quit
                                                -------------------------------------------------------""";
                        String easyKanbanOption = JOptionPane.showInputDialog(easyKanbanMenu + "\nChoose an option:");
                        
                        // Check if the user clicked "Cancel" or closed the dialog
                        if (easyKanbanOption == null) {
                            JOptionPane.showMessageDialog(null, "Goodbye!");
                            return; // Exit the loop if the user cancels
                        }
                        
                        // Convert the input to an integer
                        int easyKanbanChoice;
                        try {
                            easyKanbanChoice = Integer.parseInt(easyKanbanOption);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid input! Please enter a number.");
                            continue; // Restart the loop
                        }
                        Tasks work = new Tasks();

                        switch (easyKanbanChoice) {
                            case 1 -> // Add task functionality
                                work.addTask();
                            case 2 -> JOptionPane.showMessageDialog(null, "Coming soon...");
                            case 3 -> { login.printAccountReport();
                                JOptionPane.showMessageDialog(null, "Goodbye!");
                                return; // Exit the loop
                            }
                            default -> JOptionPane.showMessageDialog(null, "Invalid option!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
                }               }
            case 3 -> {
                login.printAccountReport();
                JOptionPane.showMessageDialog(null, "Goodbye!");
                return; // Exit the loop
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid option!");
        }
    }
}

        }
    }