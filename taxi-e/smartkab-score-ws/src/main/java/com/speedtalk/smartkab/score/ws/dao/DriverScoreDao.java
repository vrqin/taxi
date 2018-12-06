package com.speedtalk.smartkab.score.ws.dao;

import com.speedtalk.smartkab.score.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.score.ws.db.TabDriverScore;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DriverScoreDao {
    public TabDriverScore getByAccount(String driverAccount) throws NullPointerException {
        if (null == driverAccount || driverAccount.trim().equals(""))
            throw new NullPointerException("driver account is null");
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery(" from TabDriverScore where account=:account");
            q.setString("account", driverAccount);
            TabDriverScore driverScore = (TabDriverScore) q.uniqueResult();
            tx.commit();
            session.close();
            return driverScore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
