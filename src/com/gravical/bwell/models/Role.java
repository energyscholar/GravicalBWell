/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.models;

import java.io.Serializable;

/**
 *
 * @author Bruce
 */
public class Role implements Serializable {
    private String roleName;
    private int roleEnum;
    
    public Role(int roleId, String roleName) {
        this.roleEnum = roleId;
        this.roleName = roleName;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @return the roleEnum
     */
    public int getRoleEnum() {
        return roleEnum;
    }
}
