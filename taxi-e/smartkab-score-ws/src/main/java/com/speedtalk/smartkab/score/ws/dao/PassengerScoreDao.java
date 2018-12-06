package com.speedtalk.smartkab.score.ws.dao;

import com.speedtalk.smartkab.score.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.score.ws.db.TabPassengerScore;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PassengerScoreDao {
    public TabPassengerScore getByAccount(String passAccount) throws NullPointerException {
        if (null == passAccount || passAccount.trim().equals(""))
            throw new NullPointerException("passenger account is null");
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery(" from TabPassengerScore where account=:account");
            q.setString("account", passAccount);
            TabPassengerScore passengerScore = (TabPassengerScore) q.uniqueResult();
            tx.commit();
            session.close();
            return passengerScore;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
