package com.gravical.bwell.models;
// Generated 12-Feb-2013 23:08:00 by Hibernate Tools 3.2.1.GA



/**
 * Users generated by hbm2java
 */
public class Users  implements java.io.Serializable {


     private int userId;
     private String firstName;
     private String lastName;
     private Integer roleId;
     private String username;
     private String passwordHashed;

    public Users() {
    }

	
    public Users(int userId) {
        this.userId = userId;
    }
    public Users(int userId, String firstName, String lastName, Integer roleId, String username, String passwordHashed) {
       this.userId = userId;
       this.firstName = firstName;
       this.lastName = lastName;
       this.roleId = roleId;
       this.username = username;
       this.passwordHashed = passwordHashed;
    }
   
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPasswordHashed() {
        return this.passwordHashed;
    }
    
    public void setPasswordHashed(String passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    public String toString() {
        String returnValue = "[" +userId+";"+username+";"+firstName+";"+lastName+";"+passwordHashed+";"+roleId + ";]"  ;
        return returnValue;
    }


}


