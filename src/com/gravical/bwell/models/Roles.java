package com.gravical.bwell.models;
// Generated Feb 8, 2013 4:26:48 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Roles generated by hbm2java
 */
@Entity
@Table(name="ROLES"
    ,schema="BWELL"
)
public class Roles  implements java.io.Serializable {


     private int roleId;
     private String roleName;

    public Roles() {
    }

	
    public Roles(int roleId) {
        this.roleId = roleId;
    }
    public Roles(int roleId, String roleName) {
       this.roleId = roleId;
       this.roleName = roleName;
    }
   
     @Id 
    
    @Column(name="ROLE_ID", unique=true, nullable=false, precision=5, scale=0)
    public int getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
    
    @Column(name="ROLE_NAME", length=80)
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override 
    public String toString() {
        return "["+this.roleId+";"+this.roleName+"]";
    }

}


