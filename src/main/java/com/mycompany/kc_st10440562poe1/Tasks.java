/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;
import javax.swing.*;
import java.util.ArrayList;

public class Tasks {
    private final String taskName;
    private final String taskDescription;
    private final String developerDetails;
    private final int taskDuration; // in hours
    private final String taskID; // Auto-incrementing TaskID
    private final TaskStatus taskStatus;

    // Task lists for different statuses
    private static final ArrayList<Tasks> todoTasks = new ArrayList<>();
    private static final ArrayList<Tasks> doingTasks = new ArrayList<>();
    private static final ArrayList<Tasks> doneTasks = new ArrayList<>();
    private static final ArrayList<Tasks> taskList = new ArrayList<>();
    private static int nextTaskNumber = 0; // Static for auto-incrementing TaskID

    // Constructor
    public Tasks(String taskName, String taskDescription, String developerDetails, int taskDuration, TaskStatus taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus; // Set the status passed in
        this.taskID = createTaskID(); // Generate Task ID
        nextTaskNumber++; // Increment task number for next task
        addTaskToList();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
    return "Task Name: " + taskName + ", Description: " + taskDescription +
           ", Developer: " + developerDetails + ", Duration: " + taskDuration +
           " hours, Status: " + taskStatus;
}
                    // Method to generate Task ID
    private String createTaskID() {
        String initials = taskName.substring(0, 2).toUpperCase();
        String lastThree = developerDetails.length() >= 3 ? 
            developerDetails.substring(developerDetails.length() - 3).toUpperCase() : 
            developerDetails.toUpperCase();
        return initials + ":" + nextTaskNumber + ":" + lastThree;
    }
    // Add the task to the appropriate list based on its status
    private void addTaskToList() {
        switch (taskStatus) {
            case TO_DO -> todoTasks.add(this);
            case DOING -> doingTasks.add(this);
            case DONE -> doneTasks.add(this);
        }
        taskList.add(this); // Add to the general task list
    }

    // Method to add a task (static method for user input)
    // Method to add multiple tasks
    public static void addTasks() {
        System.out.println("Starting to add new tasks...");

        // Prompt for the number of tasks
        int numberOfTasks;
        while (true) {
            String numberString = JOptionPane.showInputDialog("How many tasks would you like to capture?");
            if (numberString == null) return; // User clicked cancel
            try {
                numberOfTasks = Integer.parseInt(numberString);
                if (numberOfTasks <= 0) {
                    JOptionPane.showMessageDialog(null, "Please enter a positive number!");
                    continue;
                }
                break; // Valid number of tasks
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number!");
            }
        }

        // Loop to capture each task
        for (int i = 0; i < numberOfTasks; i++) {
            addTask(); // Call the existing addTask method for each task
        }

        // Optionally, display all captured tasks or return to the kanban menu
        showAllTasks();
    }

    // Existing method to add a single task
    public static void addTask() {
        System.out.println("Starting to add a new task...");
        String taskName = JOptionPane.showInputDialog("Enter Task Name:");
        if (taskName == null || taskName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Task name cannot be empty!");
            return;
        }
        System.out.println("Task Name: " + taskName);

        String taskDescription = promptForTaskDescription();
        if (taskDescription == null) {
            System.out.println("User  cancelled task description input.");
            return; // User cancelled
        }
        System.out.println("Task Description: " + taskDescription);

        String developerFirstName = JOptionPane.showInputDialog("Enter Developer's First Name:");
        if (developerFirstName == null || developerFirstName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Developer's first name cannot be empty!");
            return;
        }
        String developerLastName = JOptionPane.showInputDialog("Enter Developer's Last Name:");
        if (developerLastName == null || developerLastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Developer's last name cannot be empty!");
            return;
        }

        String developerDetails = developerFirstName + " " + developerLastName;
        System.out.println("Developer Details: " + developerDetails);

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

        System.out.println("Task Duration: " + taskDuration);

    TaskStatus taskStatus = promptForTaskStatus();
    System.out.println("Task Status: " + taskStatus);

            // Create a new task
        Tasks newTask = new Tasks(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
        JOptionPane.showMessageDialog(null, "Task successfully captured!\n\n" + newTask.printTaskDetails());
        System.out.println("New task added successfully.");
    }

    // Prompt for task description
    private static String promptForTaskDescription() {
        while (true) {
            String taskDescription = JOptionPane.showInputDialog("Enter Task Description:");
            if (taskDescription == null) return null; // User clicked cancel
            if (taskDescription.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Task description cannot be empty!");
                continue;
            }
            if (taskDescription.length() > 50) {
                JOptionPane.showMessageDialog(null, "Task description cannot exceed 50 characters!");
                continue;
            }
            return taskDescription; // Valid description
        }
    }

    // Prompt for task status
   private static TaskStatus promptForTaskStatus() {
    String[] options = {"TO_DO", "DOING", "DONE"};
    String selectedStatus = (String) JOptionPane.showInputDialog(null, "Select Task Status:", "Task Status",
            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

    if (selectedStatus == null) { // User cancelled
        JOptionPane.showMessageDialog(null, "Task status selection cancelled. Defaulting to TO_DO.");
        return TaskStatus.TO_DO; // Default to TO_DO
    }
    
    try {
        return TaskStatus.valueOf(selectedStatus); // Convert string to TaskStatus enum
    } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "Invalid status selected. Defaulting to TO_DO.");
        return TaskStatus.TO_DO; // Fallback in case of invalid selection
    }
}

    // Method to print task details
    public String printTaskDetails() {
        return String.format("Task Name: %s\nTask Description: %s\nDeveloper Details: %s\nTask Duration: %d hours\nTask ID: %s\nTask Status: %s",
                taskName, taskDescription, developerDetails, taskDuration, taskID, taskStatus); // Corrected taskID format
    }

    // Method to calculate total hours of all tasks
    public static int returnTotalHours() {
        return taskList.stream().mapToInt(task -> task.taskDuration).sum();
    }

    // Method to show all tasks (for demonstration purposes)
    public static void showAllTasks() {
        if (taskList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Coming Soon");
            return;
        }

        StringBuilder compiledTasks = new StringBuilder("All Tasks:\n");
        for (Tasks task : taskList) {
            compiledTasks.append(task.printTaskDetails()).append("\n\n");
        }
        // Calculate total duration of all tasks
    int totalDuration = returnTotalHours();
    compiledTasks.append("Total Accumulated Duration: ").append(totalDuration).append(" hours");

    JOptionPane.showMessageDialog(null, compiledTasks.toString(), "Tasks", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "No tasks available in " + category + " category.");
        } else {
            for (Tasks task : tasksToShow) {
                compiledTasks.append(task.printTaskDetails()).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, compiledTasks.toString(), category + " Tasks", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Enum representing the status of a task
    public enum TaskStatus {
        TO_DO, DOING, DONE
    }

    // Method to check task description length
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
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
        return taskID; // Return the auto-generated TaskID
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
       String getTaskDescription() {
        return taskDescription;
                }
}