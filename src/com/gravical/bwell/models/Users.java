/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.models;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author User
 */
public class Users implements TableModel {

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return 4;
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getColumnName(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
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
