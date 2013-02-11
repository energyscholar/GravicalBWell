/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class RolesTest {
    static Roles role1, role2, role3, role4, role5;
    
    public RolesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {        
        role1 = new Roles(1,"Administrator");
        role2 = new Roles(2,"Superviser");
        role3 = new Roles(3,"Intern");
        role4 = new Roles(4,"Client");
        role5 = new Roles(5,"Guest");                 
 }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRoleName method, of class Role.
     */
    @Test
    public void testRole() {
        String expResult = "[1;Administrator]";
        String result = role1.toString();
        assertEquals(expResult, result);
        expResult = "[2;Superviser]";
        result = role2.toString();
        assertEquals(expResult, result);
        expResult = "[3;Intern]";
        result = role3.toString();
        assertEquals(expResult, result);
        expResult = "[4;Client]";
        result = role4.toString();
        assertEquals(expResult, result);
        expResult = "[5;Guest]";
        result = role5.toString();
        assertEquals(expResult, result);
    }
}
