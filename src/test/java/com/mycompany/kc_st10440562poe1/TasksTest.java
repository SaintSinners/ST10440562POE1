/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
/**
 *
 * @author RC_Student_lab
 */
public class TasksTest {
    private Tasks task;
    private Tasks task2;
    private String TO_DO;
    private String DOING;
    private static ArrayList<Tasks> taskList; // Declared and initialized empty task list
    public TasksTest() {
    }
    
    @BeforeEach
    public void setUp() {
         // Setting up a sample task before each test, Instance of a class with parameters
        task = new Tasks("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, Tasks.TaskStatus.TO_DO);
        task2 = new Tasks("Add Task Feature", "Create Add Task Feature to add task users", "Mike Smith", 10, Tasks.TaskStatus.DOING);
        // Initialize the task list before each test
        taskList = new ArrayList<>();
    }
    
    @AfterEach
    public void tearDown() {
    }
    //Test of toString method, of class Tasks.
    @Test   
    public void testTaskCreation() {
        org.junit.jupiter.api.Assertions.assertNotNull(task);
        org.junit.jupiter.api.Assertions.assertEquals("Login Feature", task.getTaskName());
        org.junit.jupiter.api.Assertions.assertEquals("Create Add Task Feature to add task users", task.getTaskDescription());
        org.junit.jupiter.api.Assertions.assertEquals("Robyn Harrison", task.getDeveloperDetails());
        org.junit.jupiter.api.Assertions.assertEquals(8, task.getTaskDuration());
        org.junit.jupiter.api.Assertions.assertEquals(Tasks.TaskStatus.TO_DO, task.getTaskStatus());
        org.junit.jupiter.api.Assertions.assertTrue(task.getTaskID().length() > 0);
    }
    @Test   
    public void testTaskCreation2() {
        org.junit.jupiter.api.Assertions.assertNotNull(task2);
        org.junit.jupiter.api.Assertions.assertEquals("Add Task Feature", task2.getTaskName());
        org.junit.jupiter.api.Assertions.assertEquals("Create Login to authenticate users", task2.getTaskDescription());
        org.junit.jupiter.api.Assertions.assertEquals("Mike Smith", task2.getDeveloperDetails());
        org.junit.jupiter.api.Assertions.assertEquals(10, task2.getTaskDuration());
        org.junit.jupiter.api.Assertions.assertEquals(Tasks.TaskStatus.DOING, task2.getTaskStatus());
        org.junit.jupiter.api.Assertions.assertTrue(task2.getTaskID().length() > 0);
    }
    @Test 
    public void testTaskDescriptionLength() {
        org.junit.jupiter.api.Assertions.assertTrue(task.checkTaskDescription());
        // Create a task with a long description
        Tasks longDescriptionTask = new Tasks("Login Feature", "Create Login to authenticate users, This description is way too long and should fail the validation because it exceeds the limit of fifty characters.", "Robyn Harrison", 8, Tasks.TaskStatus.TO_DO);
        org.junit.jupiter.api.Assertions.assertFalse(longDescriptionTask.checkTaskDescription());
    }
    @Test 
    public void testTotalHoursCalculation() {
        // Add multiple tasks to the task list
        Tasks tasks = new Tasks("Login Feature", "Create Login to authenticate users", "Robyn Harrison", 8, Tasks.TaskStatus.TO_DO);
        Tasks tasks1 = new Tasks("Add Task Feature", "Create AddTask Feature to add task users", "Mike Smith", 10, Tasks.TaskStatus.DOING);
        Tasks tasks2 = new Tasks("Task 3", "Description 3", "Dev 3", 3, Tasks.TaskStatus.DONE);
        taskList.add(tasks);
        taskList.add(tasks1);
        taskList.add(tasks2);
        int totalHours = 0;
        for (Tasks t : taskList) {
            totalHours += t.getTaskDuration();
        }
        org.junit.jupiter.api.Assertions.assertEquals(21, totalHours);
    }
    @Test
    public void totalHoursAccumulated() {
        // Initialize the task list
        taskList = new ArrayList<>(); // Declared and initialized empty task list
        // Create and add 5 tasks with durations that sum up to 89 hours
        for (int i = 1; i <= 5; i++) {
            String taskName = "Task " + i; // Task name matches Developer number
            String taskDescription = "Description drafted by Developer " + i; // Description by Developer
            int taskDuration;
            // Split durations to sum up to 89 hours
            if (i < 5) {
                taskDuration = 15; // First four tasks have a duration of 15 hours each
            } else {
                taskDuration = 29; // Fifth task has a duration of 29 hours
            }
            // Create a new task
            Tasks newTask = new Tasks(taskName, taskDescription, "Developer " + i, taskDuration, Tasks.TaskStatus.TO_DO);
            
            // Add the task to the list
            taskList.add(newTask); 
            // Print out the details of each task
            System.out.println("Created: " + newTask);
        }
        // Calculate total hours
        int totalHours = 0;
        for (Tasks t : taskList) {
            totalHours += t.getTaskDuration();
        }
        // Assert that the total hours equals 89
        org.junit.jupiter.api.Assertions.assertEquals(89, totalHours);
    }
    //Test of addTasks method, of class Tasks.
    @Test
    public void testAddTasks() {
        System.out.println("addTasks");
        Tasks.addTasks();
    }

    //Test of addTask method, of class Tasks.
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Tasks.addTask();
    }
    //Test of showAllTasks method, of class Tasks.
    @Test
    public void testShowAllTasks() {
        System.out.println("showAllTasks");
        Tasks.showAllTasks();
    }
    //Test of showTasks method, of class Tasks.
    @Test
    public void testShowTasks() {
        System.out.println("showTasks");
        String category = "";
        Tasks.showTasks(category);
    }
}