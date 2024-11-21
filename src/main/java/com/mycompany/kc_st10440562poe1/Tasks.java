/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Tasks {

    // Static list to hold all tasks
    public static final ArrayList<Tasks> taskList = new ArrayList<>();
    private static int nextTaskNumber = 0; // Static for auto-incrementing TaskID

    // Task lists for different statuses
    private static final ArrayList<Tasks> todoTasks = new ArrayList<>();
    private static final ArrayList<Tasks> doingTasks = new ArrayList<>();
    private static final ArrayList<Tasks> doneTasks = new ArrayList<>();
    
    // Task status management
    private static final Map<TaskStatus, List<Tasks>> taskLists = new EnumMap<>(TaskStatus.class);

    // Task attributes
    final String taskName;
    private final String taskDescription;
    final String developerDetails;
    private int taskDuration; // in hours
    private final String taskID; // Auto-incrementing TaskID
    private TaskStatus taskStatus;

    // Static block to initialize task lists for different statuses
    static {
        taskLists.put(TaskStatus.TO_DO, todoTasks);
        taskLists.put(TaskStatus.DOING, doingTasks);
        taskLists.put(TaskStatus.DONE, doneTasks);
    }

    // Constructor
    public Tasks(String taskName, String taskDescription, String developerDetails, int taskDuration, TaskStatus taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus; // Set the status passed in
        this.taskID = createTaskID(); // Generate Task ID
        nextTaskNumber++; // Increment task number for the next task
        taskList.add(this); // Add to the general task list
        addTaskToList();
    }

    // Method to calculate total hours of all tasks
    public static int returnTotalHours() {
        return taskList.stream().mapToInt(task -> task.taskDuration).sum();
    }

    // Method to generate Task ID
    private String createTaskID() {
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastThree = developerDetails.length() >= 3 ? 
            developerDetails.substring(developerDetails.length() - 3).toUpperCase() : 
            developerDetails.toUpperCase();
        return initials + ":" + nextTaskNumber + ":" + lastThree;
    }

    // Method to add the task to the appropriate task list based on status
    private void addTaskToList() {
        taskLists.get(taskStatus).add(this);
    }

    // Getters for task properties
    public String getTaskName() {
        return taskName;
    }

    public String getTaskID() {
        return taskID; // Return the auto-generated TaskID
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public String getDeveloperDetails() {
        return developerDetails;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    // Setter for task status
    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    // Method to print task details
    public String printTaskDetails() {
        return String.format("Task ID: %s\nName: %s\nDescription: %s\nDeveloper: %s\nDuration: %d hours\nStatus: %s",
                taskID, taskName, taskDescription, developerDetails, taskDuration, taskStatus);
    }

    // Method to show all tasks
    public static void showAllTasks() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "COMING SOON!");
            return;
        }

        StringBuilder compiledTasks = new StringBuilder("All Tasks:\n");
        int totalDuration = 0; // Initialize total duration

        for (Tasks task : taskList) {
            compiledTasks.append(task.printTaskDetails()).append("\n\n");
            totalDuration += task.getTaskDuration(); // Accumulate total duration
        }

        // Show all tasks along with the total duration
        compiledTasks.append("Total Duration: ").append(totalDuration).append(" hours");
        JOptionPane.showMessageDialog(null, compiledTasks.toString());
    }

    // Method to check task description length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }

    // Method to show tasks in a specific category
    public static void showTasks(String category) {
        StringBuilder compiledTasks = new StringBuilder(category + " Tasks:\n");
        ArrayList<Tasks> tasksToShow;

        tasksToShow = switch (category) {
            case "TO DO" -> todoTasks;
            case "DOING" -> doingTasks;
            case "DONE" -> doneTasks;
            default -> new ArrayList<>();
        };

        if (tasksToShow.isEmpty()) {
            compiledTasks.append("No tasks found in this category.");
        } else {
            for (Tasks task : tasksToShow) {
                compiledTasks.append(task.printTaskDetails()).append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, compiledTasks.toString());
    }

    // Method to add multiple tasks
    public static void addMultipleTasks() {
        int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks do you want to add?"));

        for (int i = 0; i < numberOfTasks; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name for task " + (i + 1) + ":");
            if (taskName == null || taskName.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Task addition canceled.");
                return; // Exit if canceled or empty input
            }

            String taskDescription = JOptionPane.showInputDialog("Enter task description for task " + (i + 1) + ":");
            if (taskDescription == null || taskDescription.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Task addition canceled.");
                return; // Exit if canceled or empty input
            }

            String developerDetails = JOptionPane.showInputDialog("Enter developer details for task " + (i + 1) + ":");
            if (developerDetails == null || developerDetails.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Task addition canceled.");
                return; // Exit if canceled or empty input
            }

            String durationString = JOptionPane.showInputDialog("Enter task duration (in hours) for task " + (i + 1) + ":");
            if (durationString == null || durationString.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Task addition canceled.");
                return; // Exit if canceled or empty input
            }

            int taskDuration;
            try {
                taskDuration = Integer.parseInt(durationString);
                if (taskDuration <= 0) {
                    JOptionPane.showMessageDialog(null, "Duration must be a positive number. Task not added.");
                    continue; // Skip this task if input is not valid
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid duration input. Task not added.");
                continue; // Skip this task if input is not valid
            }

            // Prompt for task status
            TaskStatus taskStatus = promptForTaskStatus(); // Assuming you have this method

            // Create a new task
            new Tasks(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
            JOptionPane.showMessageDialog(null, "Task " + (i + 1) + " added successfully!");
        }

        // After all tasks are added, show the total number of tasks added
        JOptionPane.showMessageDialog(null, "Total tasks added: " + Tasks.taskList.size());
    }

    // Example method to prompt for task status
    private static TaskStatus promptForTaskStatus() {
        String[] options = {"TO_DO", "DOING", "DONE"};
        int choice = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == -1) {
            return TaskStatus.TO_DO; // Default status if canceled
        }

        return TaskStatus.valueOf(options[choice]); // Convert string to TaskStatus enum
    }

    // Enum for Task Status
    public enum TaskStatus {
        TO_DO, DOING, DONE
    }
}