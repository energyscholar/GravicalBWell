/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.db;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class PopulateSampleData {
    private static ArrayList users = new ArrayList();
    
    private static ArrayList roles = new ArrayList();

    /**
     * @return the users
     */
    public static ArrayList getUsers() {
        return users;
    }

    /**
     * @return the roles
     */
    public static ArrayList getRoles() {
        return roles;
    }
    
    public PopulateSampleData () {
  /*      
        Roles admin      = new Roles(1,"Admin");
        Roles supervisor = new Roles(2,"Supervisor");
        Roles intern     = new Roles(3,"Intern");
        Roles client     = new Roles(4,"Client");
        roles.add(admin);
        roles.add(supervisor);
        roles.add(intern);
        roles.add(client);

        Users user1 = new Users(1, "admin1","password",  "Ad", "Min", 1);
        Users user2 = new Users(2, "super1","password",  "Super", "Viser", 2);
        Users user3 = new Users(3, "intern1","password",  "In", "tern", 3);
        Users user4 = new Users(4, "client1","password",  "Cli", "Ent", 4);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);        
    */     
    }
}