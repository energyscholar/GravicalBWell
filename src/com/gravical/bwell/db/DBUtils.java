/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.db;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class DBUtils {

    private static String QUERY_GET_BWELL_SESSIONS_COUNT = "select MAX(session_id) from BWELL.SESSIONS";
    private static Session session;
    private static SQLQuery q;

    public static int determineBwellSessionsCountFromDB() {
        session = HibernateUtil.getSessionFactory().openSession();
        int maxId = 0;

        q = session.createSQLQuery(QUERY_GET_BWELL_SESSIONS_COUNT);
        List countList = q.list();
        System.out.println("determineBwellSessionsCountFromDB before maxId = " + maxId);
        try {
            BigDecimal bd = (BigDecimal) countList.get(0);
            maxId = bd.intValue();

        } catch (Exception e) {
            // really do nothing!
        }
        System.out.println("determineBwellSessionsCountFromDB after maxId = " + maxId);


        return maxId;
    }
}
