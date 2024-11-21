/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Search {
    // This will hold the search results
    public static List<Tasks> tasks = new ArrayList<>();

    // Method to search tasks by developer name
    public static void searchByDeveloper(String developerName) {
        tasks.clear(); // Clear previous results
        for (Tasks task : Tasks.taskList) {
            System.out.println("Checking task: " + task.taskName + " assigned to " + task.developerDetails);
            if (task.developerDetails.equals(developerName)) {
                tasks.add(task);
            }
        }
        System.out.println("Tasks found: " + tasks.size());
    }

    public static void searchTasks() {
        String searchType = JOptionPane.showInputDialog("Search by:\n1. Developer Name\n2. Task Status\n3. Task Name\n4. Longest Duration Task\n5. Tasks Assigned to Developer");
        switch (searchType) {
            case "1" -> {
                String developerName = JOptionPane.showInputDialog("Enter Developer Name:");
                searchByDeveloper(developerName);
            }
            case "2" -> {
                String taskStatus = JOptionPane.showInputDialog("Enter Task Status (TO_DO, DOING, DONE):");
                searchByStatus(taskStatus);
            }
            case "3" -> {
                String taskName = JOptionPane.showInputDialog("Enter Task Name:");
                searchByName(taskName);
            }
            case "4" -> searchTasksWithLongestDuration();
            case "5" -> {
                String developerName = JOptionPane.showInputDialog("Enter Developer Name:");
                tasksAssignedToDeveloper(developerName);
            }
            default -> JOptionPane.showMessageDialog(null, "Invalid option.");
        }
    }

    public static void searchByStatus(String status) {
        List<Tasks> results = new ArrayList<>();
        for (Tasks task : tasks) {
            if (task.getTaskStatus().toString().equalsIgnoreCase(status)) {
                results.add(task);
            }
        }
        displayResults(results);
    }

    public static void searchByName(String name) {
        List<Tasks> results = new ArrayList<>();
        for (Tasks task : tasks) {
            if (task.getTaskName().equalsIgnoreCase(name)) {
                results.add(task);
            }
        }
        displayResults(results);
    }

    public static List<Tasks> searchTasksWithLongestDuration() {
        List<Tasks> result = new ArrayList<>();

        if (Tasks.taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks available.");
            return result; // Return an empty list if no tasks are available
        }

        Tasks longestTask = Tasks.taskList.get(0); // Start with the first task

        for (Tasks task : Tasks.taskList) {
            if (task.getTaskDuration() > longestTask.getTaskDuration()) {
                longestTask = task; // Update if a longer task is found
            }
        }

        // Add the longest task to the result list
        result.add(longestTask);
        
        // Optional: Display the longest task details
        JOptionPane.showMessageDialog(null, "Task with the longest duration:\n" + longestTask.printTaskDetails());
        
        return result; // Return a list containing the task with the longest duration
    }

    public static void tasksAssignedToDeveloper(String developerName) {
        tasks.clear(); // Clear previous results

        List<Tasks> results = new ArrayList<>();
        for (Tasks task : Tasks.taskList) { // Iterate over the task list
            if (task.getDeveloperDetails().equalsIgnoreCase(developerName)) { // Check if the developer matches
                results.add(task); // Add matching tasks to results
            }
        }

        // Store results in the static tasks list for testing
        tasks.addAll(results); // Add all matching tasks to the static tasks list
        displayResults(results); // Display the results
    }

    private static void displayResults(List<Tasks> results) {
        if (results.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tasks found for the developer.");
        } else {
            StringBuilder resultMessage = new StringBuilder("Tasks assigned to the developer:\n");
            for (int i = 0; i < results.size(); i++) {
                resultMessage.append(i + 1).append(": ").append(results.get(i).printTaskDetails()).append("\n");
            }
            
            // Show the list of tasks and prompt for selection
            String selectedTaskIndex = JOptionPane.showInputDialog(resultMessage.toString() + 
                "Select a task number to amend its status or delete it (or type 'cancel' to exit):");
            
            // Handle the task selection
            handleTaskSelection(selectedTaskIndex, results);
        }
    }

    private static void handleTaskSelection(String selectedTaskIndex, List<Tasks> results) {
        if (selectedTaskIndex != null && !selectedTaskIndex.trim().isEmpty()) {
            if (selectedTaskIndex.equalsIgnoreCase("cancel")) {
                return; // Exit if the user types 'cancel'
            }

            int taskIndex;
            try {
                taskIndex = Integer.parseInt(selectedTaskIndex) - 1; // Convert to zero-based index
                if (taskIndex < 0 || taskIndex >= results.size()) {
                    JOptionPane.showMessageDialog(null, "Invalid task number selected.");
                    return;
                }

                Tasks selectedTask = results.get(taskIndex);
                String action = JOptionPane.showInputDialog("Selected Task:\n" + selectedTask.printTaskDetails() + "\n\nType 'status' to amend status or 'delete' to delete the task:");

                if (action != null) {
                    if (action.equalsIgnoreCase("status")) {
                        String newStatus = JOptionPane.showInputDialog("Enter new status (TO_DO, DOING, DONE):");
                        if (newStatus != null && (newStatus.equalsIgnoreCase("TO_DO") || newStatus.equalsIgnoreCase("DOING") || newStatus.equalsIgnoreCase("DONE"))) {
                            amendTaskStatus(selectedTask, newStatus);
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid status. Please enter a valid status (TO_DO, DOING, DONE).");
                        }
                    } else if (action.equalsIgnoreCase("delete")) {
                        deleteTask(selectedTask);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid action.");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid task number.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selection cannot be empty.");
        }
    }

    public static void amendTaskStatus(Tasks task, String newStatus) {
        // Logic to update task status
        task.setTaskStatus(Tasks.TaskStatus.valueOf(newStatus.toUpperCase())); // Convert string to enum
        JOptionPane.showMessageDialog(null, "Task status updated to " + newStatus);
    }

    public static void deleteTask(Tasks task) {
        // Logic to delete a task
        Tasks.taskList.remove(task); // Remove from the static task list in Tasks class
        JOptionPane.showMessageDialog(null, "Task deleted successfully.");
    }

    public static String displayReport() {
        int totalTasks = tasks.size();
        int completedTasks = 0;
        int inProgressTasks = 0;
        int toDoTasks = 0;

        // Iterate through the tasks to count each category
        for (Tasks task : tasks) {
            switch (task.getTaskStatus()) {
                case DONE -> completedTasks++;
                case DOING -> inProgressTasks++;
                case TO_DO -> toDoTasks++;
            }
        }

        // Return the formatted report
        return String.format("Total Tasks: %d\nTasks Completed: %d\nTasks In Progress: %d\nTasks To Do: %d\n",
                totalTasks, completedTasks, inProgressTasks, toDoTasks);
    }
}