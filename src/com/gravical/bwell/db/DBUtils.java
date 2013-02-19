/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.db;

import com.gravical.bwell.models.Annotations;
import com.gravical.bwell.models.Sessions;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import java.sql.Timestamp;

/**
 *
 * @author User
 */
public class DBUtils {

    private static String QUERY_GET_BWELL_SESSIONS_COUNT = "select MAX(session_id) from BWELL.SESSIONS";
    private static String QUERY_GET_ANNOTATIONS_COUNT = "select MAX(session_id) from BWELL.ANNOTATIONS";
    private static Session session;
    private static SQLQuery q;

    public static int determineBwellSessionsCountFromDB() {
        session = HibernateUtil.getSessionFactory().openSession();
        int maxId = 0;
        q = session.createSQLQuery(QUERY_GET_BWELL_SESSIONS_COUNT);
        List countList = q.list();
        try {
            BigDecimal bd = (BigDecimal) countList.get(0);
            maxId = bd.intValue();
        } catch (Exception e) {
            // really do nothing!
        }
        return maxId;
    }

    public static int determineAnnotationsCountFromDB() {
        session = HibernateUtil.getSessionFactory().openSession();
        int maxId = 0;
        q = session.createSQLQuery(QUERY_GET_ANNOTATIONS_COUNT);
        List countList = q.list();
        try {
            BigDecimal bd = (BigDecimal) countList.get(0);
            maxId = bd.intValue();
        } catch (Exception e) {
            // really do nothing!  If we got here it's the first record
        }
        return maxId;
    }

    // Delete the BWellSession, by sessionId
    // TODO: refactor to DBUtils
    // TODO: Possibly refactor to delete by Sessions object rather than session_id
    public static void endEncounter(Sessions BWellSessionToEnd) {
        java.util.Date date = new java.util.Date();
        // TODO: Modify method to call server.  Client should not do direct delete
        // TODO: authentication check on server : does loggedInUser have sufficient authority to delete the BWellsession?
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        java.sql.Timestamp tsEnd = new java.sql.Timestamp(date.getTime());
        System.out.println("about to end BWellSessionToEnd=" + BWellSessionToEnd.getSessionId());
        BWellSessionToEnd.setSessionEnd(tsEnd);
        session.update(BWellSessionToEnd);
        session.getTransaction().commit();
        //TODO: Callback to redraw table
    }

    // Method to add an annotation, sets annotationTime to now()
    public static void addTextAnnotationToBWellSession(Sessions bWellSession, String textAnnotation) {
        java.util.Date date = new java.util.Date();
        java.sql.Timestamp rightNow = new java.sql.Timestamp(date.getTime());
        addTextAnnotationToBWellSession(bWellSession, textAnnotation, rightNow);
    }

    // Method to add an annotation
    public static void addTextAnnotationToBWellSession(Sessions bWellSession, String textAnnotation, java.sql.Timestamp annotationTime) {
        // TODO: Modify method to call server.  Client should not do direct delete
        // TODO: authentication check on server : does loggedInUser have sufficient authority to delete the BWellsession?
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        int bWellSessionID = bWellSession.getSessionId();
        int annotationId = DBUtils.determineAnnotationsCountFromDB() + 1;
        Annotations annotation = new Annotations(annotationId);
        annotation.setAnnotationText(textAnnotation);
        annotation.setAnnotationTs(annotationTime);
        annotation.setBwellSessionId(bWellSessionID);        
        session.saveOrUpdate(annotation);
        session.getTransaction().commit();
        //TODO: Callback to redraw annotations
    }

    // Returns a List of of Annotations
    public static List selectAnnotationsForGivenBWellSession(Sessions bWellSession) {
        System.out.println("selectAnnotationsForGivenBWellSession bWellSession="+bWellSession);
        int bWellSessionId = bWellSession.getSessionId();
        List resultList;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // refactor to remove the embedded SQL
//        Query q = session.createQuery("select from ANNOTATIONS WHERE BWELL_SESSION_ID = :bWellSessionId");
        Query q = session.createQuery("select from ANNOTATIONS");
//        q.setParameter("bWellSessionId", q);
        resultList = q.list();
        return resultList;
    }
}
