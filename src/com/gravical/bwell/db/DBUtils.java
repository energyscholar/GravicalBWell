/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravical.bwell.db;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author User
 */
public class DBUtils {

    private static String QUERY_GET_BWELL_SESSIONS_COUNT = "select COUNT(*) from BWELL.SESSIONS";
    private static Session session;
    private static SQLQuery q;

    public static int determineBwellSessionsCountFromDB() {
        session = HibernateUtil.getSessionFactory().openSession();
        int bwellSessionsCount = 0;
        q = session.createSQLQuery(QUERY_GET_BWELL_SESSIONS_COUNT);
        List countList = q.list();
        String count = countList.get(0).toString() ;
        System.out.println("determineBwellSessionsCountFromDB marker count = " + count);
        bwellSessionsCount = new Integer(count).intValue() ;
        return bwellSessionsCount;
    }
}
