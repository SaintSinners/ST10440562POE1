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
        // Start the application
        Run loginApp = new Run(); // Create an instance of Run to start the program
    }

    private static class Run {

        public Run() { // Using a while loop for the prompting (No Limit on Attempts)

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

                Login login = new Login();
                switch (option) {
                    case 1 -> login.registerUser ();
                    case 2 -> {
                    String loginStatus = login.loginUser ();
                    JOptionPane.showMessageDialog(null, loginStatus);
                    System.out.println("Login status: " + loginStatus); // Debugging output
                    if (loginStatus.equals("Successful Login")) {
                    JOptionPane.showMessageDialog(null, "You are now logged in.");
                    // Proceed to EasyKanban menu
                    } else {
                    System.out.println("Login failed, not proceeding to Kanban menu."); // Debugging output
    
                            // Display the EasyKanban menu
                            while (true) {
                                String easyKanbanMenu = """
                                                        Welcome to EasyKanban
                                                        1. Add task
                                                        2. Show Report
                                                        3. Task Manager
                                                        4. Quit
                                                        -------------------------------------------------------""";
                                String easyKanbanOption = JOptionPane.showInputDialog(easyKanbanMenu + "\nChoose an option:");

                                // Check if the user clicked "Cancel" or closed the dialog
                                if (easyKanbanOption == null) {
                                    String loginReport = login.getLoginReport();
                                    JOptionPane.showMessageDialog(null, "Goodbye!\n\n" + loginReport);
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

                                switch (easyKanbanChoice) {
                                    case 1 -> {
                                        // Assuming you have an AddTask class or method to handle task addition
                                        Tasks.addMultipleTasks();  // Call the method to add a new task
                                    }
                                    case 2 -> {
                                       // Show all tasks and their total durations
                                       Tasks.showAllTasks(); // Call the method to display all tasks
                                    }
                                    case 3 -> {
                                        // Invoke the search functionality
                                        Search.searchTasks(); // Call the search method
                                    }
                                    case 4 -> {
                                        String loginReport = login.getLoginReport(); // Get the login report
                                        JOptionPane.showMessageDialog(null, "Exiting EasyKanban.\n\n" + loginReport);
                                        return; // Exit the EasyKanban menu loop
                                    }
                                    default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                                }
                            }
                        }
                    }
                    case 3 -> {
                        String loginReport = login.getLoginReport(); // Get the login report
                        JOptionPane.showMessageDialog(null, "Goodbye!\n\n" + loginReport); // Display the goodbye message along with the report
                        return; // Exit the program
                        }
                    default -> JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                }
            }
        }
    }
}