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
 */
public class Tasks {

    private final ArrayList<Task> taskList = new ArrayList<>();
    private int taskCount = 0; // Keeps track of the number of tasks added

    // Enum representing the status of a task
    public enum TaskStatus {
        TO_DO, DOING, DONE
    }

    public class Task {
        private final String taskName;
        private final int taskNumber;
        private final String taskDescription;
        private final String developerDetails;
        private final int taskDuration; // in hours
        private final String taskID;
        private final TaskStatus taskStatus;

        // Constructor
        public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration) {
            this.taskName = taskName;
            this.taskNumber = taskNumber;
            this.taskDescription = taskDescription;
            this.developerDetails = developerDetails;
            this.taskDuration = taskDuration;
            this.taskID = createTaskID();
            this.taskStatus = TaskStatus.TO_DO; // Default status
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

        // Getters for task properties
        public int getTaskDuration() {
            return taskDuration;
        }

        public String getTaskName() {
            return taskName;
        }

        public String getDeveloperDetails() {
            return developerDetails;
        }

        public String getTaskID() {
            return taskID;
        }

        public TaskStatus getTaskStatus() {
            return taskStatus;
        }
    }

    // Method to add a task
    public void addTask() {
        // Prompt for task name
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        if (taskName == null || taskName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task name cannot be empty!");
            return;
        }

        // Prompt for task description
        String taskDescription = JOptionPane.showInputDialog("Enter Task Description (max 50 characters):");
        if (taskDescription != null && !new Task(taskName, taskCount, taskDescription, "", 0).checkTaskDescription()) {
            JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters!");
            return;
        }

        // Prompt for developer's first name
        String developerFirstName = JOptionPane.showInputDialog("Enter Developer's First Name:");
        if (developerFirstName == null || developerFirstName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Developer's first name cannot be empty!");
            return;
        }

        // Prompt for developer's last name
        String developerLastName = JOptionPane.showInputDialog("Enter Developer's Last Name:");
        if (developerLastName == null || developerLastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Developer's last name cannot be empty!");
            return;
        }

        // Combine first and last name into developerDetails
        String developerDetails = developerFirstName + " " + developerLastName;

        // Prompt for task duration
        int taskDuration;
        while (true) {
            String durationString = JOptionPane.showInputDialog("Enter Task Duration (in hours):");
            if (durationString == null) return; // User clicked cancel
            try {
                taskDuration = Integer.parseInt(durationString);
                if (taskDuration < 0) {
                    JOptionPane.showMessageDialog(null, "Task duration cannot be negative!");
                    continue;
                }
                break; // Valid duration
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number for task duration!");
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