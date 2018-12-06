package com.speedtalk.smartkab.ws.dao;

import com.speedtalk.smartkab.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.ws.db.TabFeedback;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FeedbackDao {
    public void save(TabFeedback feedback) throws NullPointerException {
        if (null == feedback)
            throw new NullPointerException();
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            session.save(feedback);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getMaxId() {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createSQLQuery("select max(id) from tab_feedback");
            long maxId = (Integer) q.uniqueResult();
            tx.commit();
            session.close();
            return maxId;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
