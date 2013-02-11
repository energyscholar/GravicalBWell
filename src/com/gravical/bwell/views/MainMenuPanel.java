/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.views;

import java.awt.event.ActionListener;

/**
 *
 * @author User
 */
public class MainMenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainMenuPanel
     */
    public MainMenuPanel() {
        initComponents();
    }

    public void LogoutButtonActionListener(ActionListener a) {
        LogoutButton.addActionListener(a);
    }    

    public void AdminButtonActionListener(ActionListener a) {
        AdminMenuButton.addActionListener(a);
    }    

    public void SessionButtonActionListener(ActionListener a) {
        SessionButton.addActionListener(a);
    }    

    public void SuperviseButtonActionListener(ActionListener a) {
        SuperviseButton.addActionListener(a);
    }    

    public void ReviewOldSessionsButtonActionListener(ActionListener a) {
        ReviewEncountersButton.addActionListener(a);
    }    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        LogoutButton = new javax.swing.JToggleButton();
        SessionButton = new javax.swing.JButton();
        SuperviseButton = new javax.swing.JButton();
        ReviewEncountersButton = new javax.swing.JButton();
        AdminMenuButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Main Menu");
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 600));

        LogoutButton.setText("Logout");

        SessionButton.setText("Session");

        SuperviseButton.setText("Supervise");

        ReviewEncountersButton.setText("Review Encounters");

        AdminMenuButton.setText("Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(LogoutButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdminMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(SessionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(SuperviseButton)
                        .addGap(72, 72, 72)
                        .addComponent(ReviewEncountersButton)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogoutButton))
                .addGap(293, 293, 293)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SessionButton)
                    .addComponent(SuperviseButton)
                    .addComponent(ReviewEncountersButton)
                    .addComponent(AdminMenuButton))
                .addContainerGap(338, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminMenuButton;
    private javax.swing.JToggleButton LogoutButton;
    private javax.swing.JButton ReviewEncountersButton;
    private javax.swing.JButton SessionButton;
    private javax.swing.JButton SuperviseButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
