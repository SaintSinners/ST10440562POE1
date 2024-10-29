/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.kc_st10440562poe1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author RC_Student_lab
 */
public class TasksTest {
    
    public TasksTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Tasks.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Tasks instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTasks method, of class Tasks.
     */
    @Test
    public void testAddTasks() {
        System.out.println("addTasks");
        Tasks.addTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class Tasks.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        Tasks.addTask();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printTaskDetails method, of class Tasks.
     */
    @Test
    public void testPrintTaskDetails() {
        System.out.println("printTaskDetails");
        Tasks instance = null;
        String expResult = "";
        String result = instance.printTaskDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnTotalHours method, of class Tasks.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        int expResult = 0;
        int result = Tasks.returnTotalHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showAllTasks method, of class Tasks.
     */
    @Test
    public void testShowAllTasks() {
        System.out.println("showAllTasks");
        Tasks.showAllTasks();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTasks method, of class Tasks.
     */
    @Test
    public void testShowTasks() {
        System.out.println("showTasks");
        String category = "";
        Tasks.showTasks(category);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkTaskDescription method, of class Tasks.
     */
    @Test
    public void testCheckTaskDescription() {
        System.out.println("checkTaskDescription");
        Tasks instance = null;
        boolean expResult = false;
        boolean result = instance.checkTaskDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskDuration method, of class Tasks.
     */
    @Test
    public void testGetTaskDuration() {
        System.out.println("getTaskDuration");
        Tasks instance = null;
        int expResult = 0;
        int result = instance.getTaskDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskName method, of class Tasks.
     */
    @Test
    public void testGetTaskName() {
        System.out.println("getTaskName");
        Tasks instance = null;
        String expResult = "";
        String result = instance.getTaskName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeveloperDetails method, of class Tasks.
     */
    @Test
    public void testGetDeveloperDetails() {
        System.out.println("getDeveloperDetails");
        Tasks instance = null;
        String expResult = "";
        String result = instance.getDeveloperDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskID method, of class Tasks.
     */
    @Test
    public void testGetTaskID() {
        System.out.println("getTaskID");
        Tasks instance = null;
        String expResult = "";
        String result = instance.getTaskID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskStatus method, of class Tasks.
     */
    @Test
    public void testGetTaskStatus() {
        System.out.println("getTaskStatus");
        Tasks instance = null;
        Tasks.TaskStatus expResult = null;
        Tasks.TaskStatus result = instance.getTaskStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaskDescription method, of class Tasks.
     */
    @Test
    public void testGetTaskDescription() {
        System.out.println("getTaskDescription");
        Tasks instance = null;
        String expResult = "";
        String result = instance.getTaskDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
