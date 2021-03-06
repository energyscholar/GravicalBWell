/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.views;

import com.gravical.bwell.db.HibernateUtil;
import com.gravical.bwell.models.Roles;
import com.gravical.bwell.models.Sessions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class ReviewEncountersPanel extends javax.swing.JPanel {

    private static String QUERY_ALL_BWELL_SESSIONS = "from Sessions";
    // TODO: Make this a stored procedure
    private static String DELETE_ONE_BWELL_SESSIONS = "DELETE FROM SESSIONS WHERE 0 = 0 AND session_id = ";
    private static List bwellSessionsList;
    private static Session session;

    /**
     * Creates new form ReviewEncountersPanel
     */
    public ReviewEncountersPanel() {
        initComponents();
        loadBwellSessions();
        this.DeleteAllEncountersDisplayedButton.setEnabled(false);
        this.CancelButton.setEnabled(false);
    }

    public void loadBwellSessions() {
        try {
            System.out.println("executeHQLQuery started");
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(QUERY_ALL_BWELL_SESSIONS);
            List resultList = q.list();
            bwellSessionsList = resultList;
            displayResult(bwellSessionsList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            System.out.println("executeHQLQuery failed");
            he.printStackTrace();
        }
    }

    private void displayResult(List resultList) {
        // TODO: update Vector to ArrayList
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Encounter ID");
        tableHeaders.add("Start");
        tableHeaders.add("End");
        tableHeaders.add("Description");

        for (Object o : resultList) {
            Sessions bwellSession = (Sessions) o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(bwellSession.getSessionId());
            oneRow.add(bwellSession.getSessionStart());
            oneRow.add(bwellSession.getSessionEnd());
            oneRow.add(bwellSession.getSessionDescription());

            tableData.add(oneRow);
        }
        pastEncountersTable.setModel(new DefaultTableModel(tableData, tableHeaders));
    }

    // Delete the BWellSession, by sessionId
    // TODO: refactor to DBUtils
    // TODO: Possibly refactor to delete by Sessions object rather than session_id
    public void deleteEncounter(Sessions BWellSessionToDelete) {
        System.out.println("begin deleteEncounter" );
        // TODO: Modify method to call server.  Client should not do direct delete
        // TODO: authentication check on server : does loggedInUser have sufficient authority to delete the BWellsession?
        SQLQuery q;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        // TODO: rewrite as Stored Procedure, none of this raw SQL nonsense
        System.out.println("about to delete = BWellSessionToDelete=" + BWellSessionToDelete);
        session.delete(BWellSessionToDelete);
        session.getTransaction().commit();
        loadBwellSessions();
    }

    public void HomeButtonActionListener(ActionListener a) {
        HomeButton.addActionListener(a);
    }

    public void UserProfileActionListener(ActionListener a) {
        UserProfileButton.addActionListener(a);
    }

    public void SettingsActionListener(ActionListener a) {
        SettingsButton.addActionListener(a);
    }

    public void LogoutActionListener(ActionListener a) {
        LogoutButton.addActionListener(a);
    }

    public void ReviewEncounterActionListener(ActionListener a) {
        ReviewEncounterButton.addActionListener(a);
    }

    public void DeleteEncounterActionListener(ActionListener a) {
        DeleteEncounterButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Sessions selectedBWellSession;
                        selectedBWellSession = (Sessions) bwellSessionsList.get(pastEncountersTable.getSelectedRow());
                        // TODO Refactor to visibly remove sessions_id from pastEncountersTable!
                        //pastEncountersTable.getValueAt(0, pastEncountersTable.getSelectedRow()); // get the 0th column of the selected row
                        //selectedBWellSession = (Sessions) pastEncountersTable.getSelectedRow();
                        System.out.println("DeleteEncounterActionListener DELETE pressed.  Selected BWellSessions is ...  selectedBWellSession = " + selectedBWellSession );

                        deleteEncounter(selectedBWellSession);
                        //throw new UnsupportedOperationException("Not supported yet.");
                    }
                });
    }

    public void DeleteAllEncountersDisplayedActionListener(ActionListener a) {
        DeleteAllEncountersDisplayedButton.addActionListener(a);
    }

    public void CancelButtonActionListener(ActionListener a) {
        CancelButton.addActionListener(a);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogoutButton = new javax.swing.JButton();
        HelpButton = new javax.swing.JButton();
        SettingsButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        UserProfileButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SupervisorDropDown = new javax.swing.JComboBox();
        ClientDropDown = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        DateForSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ClearDateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pastEncountersTable = new javax.swing.JTable();
        ReviewEncounterButton = new javax.swing.JButton();
        DeleteEncounterButton = new javax.swing.JButton();
        DeleteAllEncountersDisplayedButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();

        LogoutButton.setText("Logout");

        HelpButton.setText("Help");

        SettingsButton.setText("Settings");

        HomeButton.setText("Home");

        UserProfileButton.setText("User Profile");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Review Past Encounter");

        jLabel2.setText("Supervisor");

        jLabel3.setText("Client");

        SupervisorDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dr Doe", "Dr Smith" }));

        ClientDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Client Smith", "Client Jones" }));

        jLabel4.setText("Date:");

        jLabel5.setText("MM/DD/YYYY");

        ClearDateButton.setText("Clear Date");
        ClearDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearDateButtonActionPerformed(evt);
            }
        });

        pastEncountersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Saved", "Title", "Description", "Started At"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pastEncountersTable);

        ReviewEncounterButton.setText("Review");

        DeleteEncounterButton.setText("Delete");

        DeleteAllEncountersDisplayedButton.setText("Delete All Displayed");

        CancelButton.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ClearDateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(SupervisorDropDown, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ClientDropDown, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(HomeButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(UserProfileButton)))
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(SettingsButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LogoutButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(HelpButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ReviewEncounterButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(DeleteEncounterButton)
                                .addGap(39, 39, 39)
                                .addComponent(DeleteAllEncountersDisplayedButton)
                                .addGap(33, 33, 33)
                                .addComponent(CancelButton)))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HomeButton)
                    .addComponent(UserProfileButton)
                    .addComponent(SettingsButton)
                    .addComponent(LogoutButton)
                    .addComponent(HelpButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SupervisorDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ClientDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(DateForSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClearDateButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReviewEncounterButton)
                    .addComponent(DeleteEncounterButton)
                    .addComponent(DeleteAllEncountersDisplayedButton)
                    .addComponent(CancelButton))
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ClearDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearDateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearDateButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton ClearDateButton;
    private javax.swing.JComboBox ClientDropDown;
    private javax.swing.JTextField DateForSearch;
    private javax.swing.JButton DeleteAllEncountersDisplayedButton;
    private javax.swing.JButton DeleteEncounterButton;
    private javax.swing.JButton HelpButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JButton LogoutButton;
    private javax.swing.JButton ReviewEncounterButton;
    private javax.swing.JButton SettingsButton;
    private javax.swing.JComboBox SupervisorDropDown;
    private javax.swing.JButton UserProfileButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable pastEncountersTable;
    // End of variables declaration//GEN-END:variables
}
