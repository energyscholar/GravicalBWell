package com.gravical.bwell.models;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.gravical.bwell.models.Roles;
import com.gravical.bwell.models.Users;
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
public class UsersTest {
        static Users user1, user2, user3, user4, user5;
    
    public UsersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        user1 = new Users(1,"us","er1",5,"user1","password");
        user2 = new Users(2,"us","er2",4,"user2","password");
        user3 = new Users(3,"us","er3",3,"user3","password");
        user4 = new Users(4,"us","er4",2,"user4","password");
        user5 = new Users(5,"us","er5",1,"user5","password");
        
    }

    @Test
    public void testUser() {
        String expectedValue1 = "[1;user1;us;er1;password;5;]";
        String actualValue1 = user1.toString() ;
        assertEquals(expectedValue1, actualValue1);
        String expectedValue2 = "[2;user2;us;er2;password;4;]";
        String actualValue2 = user2.toString() ;
        assertEquals( expectedValue2,actualValue2);
        String expectedValue3 = "[3;user3;us;er3;password;3;]";
        String actualValue3 = user3.toString() ;
        assertEquals( expectedValue3,actualValue3);
        String expectedValue4 = "[4;user4;us;er4;password;2;]";
        String actualValue4 = user4.toString() ;
        assertEquals( expectedValue4,actualValue4);
        String expectedValue5 = "[5;user5;us;er5;password;1;]";
        String actualValue5 = user5.toString() ;
        assertEquals( expectedValue5,actualValue5);
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
