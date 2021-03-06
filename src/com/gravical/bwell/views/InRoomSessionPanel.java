/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.views;

import com.gravical.bwell.controller.MVCController;
import com.gravical.bwell.db.DBUtils;
import com.gravical.bwell.db.HibernateUtil;
import com.gravical.bwell.models.Roles;
import com.gravical.bwell.models.Sessions;
import com.gravical.bwell.models.Users;
import java.awt.event.ActionListener;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class InRoomSessionPanel extends javax.swing.JPanel {

    private Users initatingUser;
    // client is the person with whom the session is being started
    private Users client;
    // the gravical media bwellSession
    private Sessions bwellSession;
    // the Hibernate session
    private static Session session;
    private List annotations;

    /**
     * Creates new form StartInRoomSessionPanel
     */
    public InRoomSessionPanel() {
        initComponents();
    }

    public void loadAnnotations() {
        System.out.print("InRoomSessionPanel bwellSession="+bwellSession);
        this.setAnnotations(DBUtils.selectAnnotationsForGivenBWellSession(bwellSession));        
        System.out.print("InRoomSessionPanel annotations="+getAnnotations());
    }    
    
    public void HomeButtonActionListener(ActionListener a) {
        HomeButton.addActionListener(a);
    }

    public void RecordButtonActionListener(ActionListener a) {
        recordButton.addActionListener(a);
    }

    public void EndEncounterButtonActionListener(ActionListener a) {
        endEncounterButton.addActionListener(a);
    }

    public void TextAnnotationButtonActionListener(ActionListener a) {
        this.textAnnotationButton.addActionListener(a);
    }

    public void startInRoomSession() {
        setBwellSession(new Sessions());
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp tsStart = new java.sql.Timestamp(date.getTime());
        java.sql.Timestamp tsEnd = new java.sql.Timestamp(date.getTime() + 3600 );
        int newSessionId = 0;
        try {
            newSessionId = DBUtils.determineBwellSessionsCountFromDB() + 1;
        }
        catch (Exception e) {
            System.out.println("process of starting an in-room session failed when the SQL to get SESSIONS.COUNT failed");
            e.printStackTrace();
        }
        
        getBwellSession().setSessionId(newSessionId);
        getBwellSession().setSessionStart(tsStart);
        // TODO: Write Server code to END stranded sessions.
        //bwellSession.setSessionEnd(tsEnd);
        getBwellSession().setSessionInitiator(MVCController.loggedInUser.getUserId() );
        getBwellSession().setSessionParticipant1Id(getClient().getUserId());
        getBwellSession().setSessionDescription("Session with " + MVCController.loggedInUser.getUsername() + " and " + getClient().getUsername() );
        getBwellSession().setSessionSummary("Session summary");        
        // save the bwell session
        System.out.println("startInRoomSession bwellSession = " + getBwellSession());
        HibernateUtil.getSessionFactory().openSession();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.saveOrUpdate(getBwellSession());
        session.getTransaction().commit();
        loadAnnotations();
        
    }

    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HomeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        cameraStubImageLabel1 = new javax.swing.JLabel();
        cameraOneLabel = new javax.swing.JLabel();
        cameraTwoLabel = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        cameraStubImageLabel2 = new javax.swing.JLabel();
        textAnnotationButton = new javax.swing.JButton();
        recordButton = new javax.swing.JButton();
        endEncounterButton = new javax.swing.JButton();
        discussionLabel = new javax.swing.JLabel();
        newChatMessageTextField = new javax.swing.JTextField();
        sendChatMessageButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        previousEncounterList = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();

        HomeButton.setText("Home");
        HomeButton.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("In Room Session");

        jInternalFrame1.setVisible(true);

        cameraStubImageLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gravical/bwell/resources/camera_sample_hand.png"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cameraStubImageLabel1)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cameraStubImageLabel1)
        );

        cameraOneLabel.setText("Camera 1");

        cameraTwoLabel.setText("Camera 2");

        jInternalFrame2.setVisible(true);

        cameraStubImageLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/gravical/bwell/resources/camera_sample_hand.png"))); // NOI18N

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cameraStubImageLabel2)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cameraStubImageLabel2)
        );

        textAnnotationButton.setText("Add Annotation");

        recordButton.setText("Record");

        endEncounterButton.setText("End Encounter");

        discussionLabel.setText("Discussion");

        sendChatMessageButton.setText("Chat");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        previousEncounterList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Previous Encounter 1", "Previous Encounter 2" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(previousEncounterList);

        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(HomeButton)
                        .addGap(258, 258, 258)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textAnnotationButton)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(discussionLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(newChatMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sendChatMessageButton))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(59, 59, 59)
                                        .addComponent(recordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(endEncounterButton)
                                        .addGap(31, 31, 31))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(cameraOneLabel)
                                .addGap(151, 151, 151)
                                .addComponent(cameraTwoLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(HomeButton)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cameraTwoLabel)
                    .addComponent(cameraOneLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jInternalFrame2)
                    .addComponent(jInternalFrame1)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textAnnotationButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(recordButton)
                            .addComponent(endEncounterButton))
                        .addGap(17, 17, 17)
                        .addComponent(discussionLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newChatMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendChatMessageButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 804, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 591, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HomeButton;
    public javax.swing.JLabel cameraOneLabel;
    private javax.swing.JLabel cameraStubImageLabel1;
    private javax.swing.JLabel cameraStubImageLabel2;
    public javax.swing.JLabel cameraTwoLabel;
    private javax.swing.JLabel discussionLabel;
    private javax.swing.JButton endEncounterButton;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField newChatMessageTextField;
    private javax.swing.JList previousEncounterList;
    private javax.swing.JButton recordButton;
    private javax.swing.JButton sendChatMessageButton;
    public javax.swing.JButton textAnnotationButton;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the initatingUser
     */
    public Users getInitatingUser() {
        return initatingUser;
    }

    /**
     * @param initatingUser the initatingUser to set
     */
    public void setInitatingUser(Users initatingUser) {
        this.initatingUser = initatingUser;
    }

    /**
     * @return the client
     */
    public Users getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Users client) {
        this.client = client;
    }

    /**
     * @return the bwellSession
     */
    public Sessions getBwellSession() {
        return bwellSession;
    }

    /**
     * @param bwellSession the bwellSession to set
     */
    public void setBwellSession(Sessions bwellSession) {
        this.bwellSession = bwellSession;
    }

    /**
     * @return the annotations
     */
    public List getAnnotations() {
        return annotations;
    }

    /**
     * @param annotations the annotations to set
     */
    public void setAnnotations(List annotations) {
        this.annotations = annotations;
    }
}
