/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kc_st10440562poe1;
import java.util.*;

/**
 *
 * @author RC_Student_lab
 */
public class KC_ST10440562POE1 {
    

    public static void main(String[] args) {
        //Object of a class called for the Login applicatin
        Login loginSystem = new Login();
        loginSystem.run(); 
        System.out.println("-----------------------------------------------END");
        
        //An instance of a method for the userName boolean
        Login validity = new Login();
        validity.CheckUsername("");
        System.out.println("--------------------------------------------------");
        
        //A password boolean feedback
        Login identity = new Login();
        identity.checkPassword("");
        System.out.println("--------------------------------------------------");
        
        //Print Login Status
        Login status = new Login();
        status.returnLoginStatus(true);
        System.out.println("--------------------------------------------------");
        
        //A method has been created to report back on Activities and runs at termination of program
        }
    }
