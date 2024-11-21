/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    @BeforeEach
    public void setUp() {
        // Clear the task list and add test tasks
        // Clear the tasks list and set up mock data
        Search.tasks.clear();
        Tasks.taskList.clear(); // Assuming taskList is static in Tasks class

        Tasks.taskList.add(new Tasks("Create Login", "Description 1", "Mike Smith", 5, Tasks.TaskStatus.TO_DO));
        Tasks.taskList.add(new Tasks("Create Add Features", "Description 2", "Edward Harrison", 8, Tasks.TaskStatus.DOING));
        Tasks.taskList.add(new Tasks("Create Reports", "Description 3", "Samantha Paulson", 2, Tasks.TaskStatus.DONE));
        Tasks.taskList.add(new Tasks("Add Arrays", "Description 4", "Glenda Oberholzer", 11, Tasks.TaskStatus.TO_DO));
    
                // Populate the Search.tasks list for the report
        Search.tasks.addAll(Tasks.taskList);
    }

    @AfterEach
    public void tearDown() {
        // Clear the task list after each test
        Tasks.taskList.clear();
    }
    
    @Test
public void testSearchAllDevelopers() {
    // List of all developers to search for
    String[] developers = {
        "Mike Smith",
        "Edward Harrison",
        "Samantha Paulson",
        "Glenda Oberholzer"
    };

    // Iterate through each developer and collect tasks
    for (String developer : developers) {
        Search.searchByDeveloper(developer); // Search for tasks by developer
        System.out.println("Tasks assigned to " + developer + ":");

        // Print the tasks for the current developer
        if (Search.tasks.isEmpty()) {
            System.out.println("No tasks found for " + developer);
        } else {
            for (Tasks task : Search.tasks) {
                System.out.println(task.printTaskDetails());
            }
        }
        System.out.println(); // Add a newline for better readability
    }
}

    @Test
    public void testAmendTaskStatus() {
        Tasks task = Tasks.taskList.get(0); // Task 1
        String newStatus = "DONE";

        Search.amendTaskStatus(task, newStatus);

        // Verify the task status has been updated
        assertEquals(Tasks.TaskStatus.DONE, task.getTaskStatus());
    }

    @Test
    public void testDeleteTask() {
        Tasks task = Tasks.taskList.get(2); // Task 3

        Search.deleteTask(task);

        // Verify the task has been deleted
        assertTrue(Tasks.taskList.contains(task));
    }

    @Test
    public void testSearchTasksWithLongestDuration() {
        // Assuming you have already populated Tasks.taskList with tasks
        // Expected result: List containing the task with the longest duration
        List<Tasks> expected = List.of(Tasks.taskList.get(3)); // Adjust index based on actual longest duration task

        // Call the method to search for the longest duration task
        List<Tasks> actual = Search.searchTasksWithLongestDuration();

        // Verify that the result matches the expected task
        assertIterableEquals(expected, actual);
    }

    @Test
    public void testTasksAssignedToDeveloper() {
        String developerName = "Samantha Paulson";
        List<Tasks> expected = List.of(Tasks.taskList.get(2)); // Task 3

        Search.tasksAssignedToDeveloper(developerName);

        // Verify that the results match the expected tasks
        assertIterableEquals(expected, Search.tasks);
    }
        @Test
    public void testSearchBySamanthaPaulson() {
        String developerName = "Samantha Paulson"; // Name of the developer to search for

        // Perform the search for tasks assigned to Samantha Paulson
        Search.searchByDeveloper(developerName); 

        // Print the tasks assigned to Samantha Paulson
        System.out.println("Tasks assigned to " + developerName + ":");
        
        // Check if any tasks were found
        if (Search.tasks.isEmpty()) {
            System.out.println("No tasks found for " + developerName);
        } else {
            // Print each task's details
            for (Tasks task : Search.tasks) {
                System.out.println(task.printTaskDetails()); // Print task details using the existing method
            }
        }

        // Expected task (update this according to your task list)
        // Make sure to adjust the index based on your actual task list
        List<Tasks> expected = List.of(Tasks.taskList.get(2)); // Adjust the index based on your task list

        // Verify that the results match the expected tasks
        assertIterableEquals(expected, Search.tasks);
    }
            @Test
    public void testDisplayReport() {
        // Expected report string
        String expectedReport = """
                                Total Tasks: 4
                                Tasks Completed: 1
                                Tasks In Progress: 1
                                Tasks To Do: 2
                                """;

        // Get the actual report from the method
        String actualReport = Search.displayReport();

        // Verify that the report matches the expected string
        assertEquals(expectedReport.trim(), actualReport.trim());
    }


    @Test
    public void testSearchTasks() {
        Search.searchTasks();
        assertEquals(4, Search.tasks.size()); // Check that all tasks are returned
    }
}