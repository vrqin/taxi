package com.speedtalk.order.engine.dao;

import com.speedtalk.order.engine.db.HibernateSessionFactory;
import com.speedtalk.order.engine.db.TabPhonecallbuss;
import com.speedtalk.protocol.order.OrderConstants;
import com.speedtalk.utils.ExcepPrinter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

public class OrderDao {
    public LinkedList<TabPhonecallbuss> getUnfinished(int seconds) {
        LinkedList<TabPhonecallbuss> list = new LinkedList<>();
        Transaction tx = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Query q = session.createSQLQuery("SELECT o.* FROM tab_phonecallbuss o " + "where o.`status` = 0 and TIME_TO_SEC(TIMEDIFF(NOW(),o.calltime)) < " + seconds + " ORDER BY o.calltime")
                    .addEntity(TabPhonecallbuss.class);
            List<TabPhonecallbuss> temp = q.list();
            int size = temp.size();
            for (int i = 0; i < size; i++)
                list.add(temp.get(i));
            tx.commit();
            session.close();
        } catch (Exception e) {
            try {
                tx.rollback();
            } catch (Exception e2) {
            }
            ExcepPrinter.print(e);
        }
        return list;
    }

    public TabPhonecallbuss getOrder(String orderId) {
        TabPhonecallbuss order = null;
        Transaction tx = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            order = (TabPhonecallbuss) session.get(TabPhonecallbuss.class, orderId);
            tx.commit();
            session.close();
        } catch (Exception e) {
            try {
                tx.rollback();
            } catch (Exception e2) {
            }
            ExcepPrinter.print(e);
        }
        return order;
    }

    public void update(Object obj) {
        Transaction tx = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.update(obj);
            tx.commit();
            session.close();
        } catch (Exception e) {
            try {
                tx.rollback();
            } catch (Exception e2) {
            }
            ExcepPrinter.print(e);
        }
    }

    public void acceptOrder(String orderNum, String msId, String kabNum) {
        Transaction tx = null;
        try {
            Session session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            TabPhonecallbuss order = (TabPhonecallbuss) session.get(TabPhonecallbuss.class, orderNum);
            order.setMsid(msId);
            order.setCarbox(kabNum);
            order.setAnswerde(new Timestamp(System.currentTimeMillis()));
            order.setStatus(OrderConstants.FINISHED_ORDER);
            session.update(order);
            tx.commit();
            session.close();
        } catch (Exception e) {
            try {
                tx.rollback();
            } catch (Exception e2) {
            }
            ExcepPrinter.print(e);
        }
    }
}
