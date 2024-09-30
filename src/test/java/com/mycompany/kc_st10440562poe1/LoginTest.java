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

public class LoginTest {
    @Test
    public void testCheckUsername() {
        System.out.println("CheckUsername");
        String username = "kyle!!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.CheckUsername(username);
        assertEquals(expResult, result);
    }
        @Test
    public void testCheckUsernameTrue() {
        System.out.println("CheckUsername");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.CheckUsername(username);
        assertEquals(expResult, result);
    }
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
    }
        @Test
    public void testCheckPasswordTrue() {
        System.out.println("checkPassword");
        String password = "Ch&&sec@ke99";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
    }
}
