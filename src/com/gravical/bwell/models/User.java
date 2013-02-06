/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.models;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class User implements Serializable{
    private String username;
    private String first_name;
    private String last_name;
    private int user_id;
    private Role role;
    private String hashPassword;

    public User(int userId, String userName, String newHashPassword, String firstName, String lastName, Role newRole) {
        this.user_id = userId;
        this.username = userName;
        this.hashPassword = newHashPassword;
        this.first_name = firstName;
        this.last_name = lastName;
        this.role = newRole;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * @param first_name the first_name to set
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * @return the last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * @param last_name the last_name to set
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
    
}
