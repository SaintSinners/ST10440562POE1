/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;
import javax.swing.*;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 * */

public class Tasks {
    private final ArrayList<Task> taskList = new ArrayList<>();
    private int taskCount = 0; // Keeps track of the number of tasks added

    public class Task {
    private final String taskName;
    private final int taskNumber;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration; // in hours
    private final String taskID;
    private final String taskStatus;

    // Constructor
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
        this.taskStatus = "To Do"; // Default status
    }

    // Method to check task description length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to generate Task ID
    private String createTaskID() {
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastThree = developerDetails.length() >= 3 ? developerDetails.substring(developerDetails.length() - 3).toUpperCase() : developerDetails.toUpperCase();
        return initials + ":" + taskNumber + ":" + lastThree;
    }

    // Method to print task details
    public String printTaskDetails() {
        return String.format("Task Name: %s\nTask Number: %d\nTask Description: %s\nDeveloper Details: %s\nTask Duration: %d hours\nTask ID: %s\nTask Status: %s",
                taskName, taskNumber, taskDescription, developerDetails, taskDuration, taskID, taskStatus);
    }

    public int getTaskDuration() {
        return taskDuration;
    }
}
    
    public void AddTask() {
        // Prompt for task name
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        if (taskName == null || taskName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task name cannot be empty!");
            return;
        }

        // Prompt for task description
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        if (taskDescription != null && !new Task(taskName, taskCount, taskDescription, "", 0).checkTaskDescription()) {
            JOptionPane.showMessageDialog(null, "Description exceeds 50 characters!");
            return;
        }

        // Prompt for developer details
        String developerDetails = JOptionPane.showInputDialog("Enter Developer's First and Last Name:");
        if (developerDetails == null || developerDetails.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Developer details cannot be empty!");
            return;
        }

        // Prompt for task duration
        int taskDuration;
        while (true) {
            String durationString = JOptionPane.showInputDialog("Enter Task Duration (in hours):");
            if (durationString == null) return; // User clicked cancel
            try {
                taskDuration = Integer.parseInt(durationString);
                if (taskDuration < 0) {
                    JOptionPane.showMessageDialog(null, "Duration cannot be negative!");
                    continue;
                }
                break; // Valid input
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for duration.");
            }
        }

        // Create a new task
        Task newTask = new Task(taskName, taskCount++, taskDescription, developerDetails, taskDuration);
        taskList.add(newTask);

        // Display success message and task details
        JOptionPane.showMessageDialog(null, "Task successfully captured!\n\n" + newTask.printTaskDetails());
    }

    // Method to calculate total hours
    public int returnTotalHours() {
        return taskList.stream().mapToInt(Task::getTaskDuration).sum();
    }
}