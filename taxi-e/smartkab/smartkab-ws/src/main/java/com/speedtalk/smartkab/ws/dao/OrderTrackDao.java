package com.speedtalk.smartkab.ws.dao;

import com.speedtalk.smartkab.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.ws.db.TabOrderTrack;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrderTrackDao {
    public TabOrderTrack getOrderStatus(String orderNum) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createSQLQuery("SELECT max(id) FROM tab_order_track where nodeid IN (4,6,9) and orderid=:orderNum");
            q.setString("orderNum", orderNum);
            Integer orderTrackId = (Integer) q.uniqueResult();
            TabOrderTrack tabOrderTrack = (TabOrderTrack) session.get(TabOrderTrack.class, Long.parseLong(orderTrackId.toString()));
            tx.commit();
            session.close();
            return tabOrderTrack;
        } catch (NullPointerException npe) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
