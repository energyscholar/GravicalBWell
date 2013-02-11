/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.models;

import com.gravical.bwell.controller.MVCController;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class UsersTableModel implements TableModel {
    private static ArrayList users;
    {
        users = MVCController.getUsers();
    }

    /**
     * @return the users
     */
    public static ArrayList getUsers() {
        return users;
    }

    /**
     * @param aUsers the users to set
     */
    public static void setUsers(ArrayList aUsers) {
        users = aUsers;
    }

    @Override
    public int getRowCount() {
        int rowCount = getUsers().size();
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int i) {
        String colName = "unknown";
        if (i == 1) {
            colName = "user ID";
        }
        if (i == 2) {
            colName = "username" ;           
        }
        return colName;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
