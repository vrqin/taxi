package com.speedtalk.smartkab.ws.dao;

import com.speedtalk.smartkab.ws.Utils;
import com.speedtalk.smartkab.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.ws.db.TabOrderTemp;
import com.speedtalk.smartkab.ws.db.TabPhonecallbuss;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderTempDao {
    /**
     * get unfinished order from database
     *
     * @param seconds
     * @return order collection
     */
    public Map<String, TabPhonecallbuss> getUnfinishedOrder(int seconds) {
        Map<String, TabPhonecallbuss> map = new LinkedHashMap<String, TabPhonecallbuss>();
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            // Query q = session.createSQLQuery("SELECT t.orderid,t.`status`," + "t.time FROM tab_order_temp t where TIME_TO_SEC(TIMEDIFF(NOW()," + "t.time)) < " + seconds + " ORDER BY t.time").addEntity(TabOrderTemp.class);
            Query q = session.createSQLQuery("SELECT o.* FROM tab_phonecallbuss o," + "tab_order_temp t where o.billid = t.orderid and " + "TIME_TO_SEC(TIMEDIFF(NOW(),t.time)) < " + seconds + " ORDER BY o.calltime")
                    .addEntity(TabPhonecallbuss.class);
            List<TabPhonecallbuss> list = (List<TabPhonecallbuss>) q.list();
            tx.commit();
            session.close();
            for (TabPhonecallbuss order : list) {
                map.put(order.getBillid(), order);
                System.out.println(Utils.getLogFix() + order.getBillid() + "--" + Utils.getCommonsdf()
                        .format(order.getCalltime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public void removeOrder(TabOrderTemp order) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            session.delete(order);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int deleteOrder(String orderNum) {
        int count = 0;
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            Query q = session.createSQLQuery("delete from tab_order_temp where orderid=:id");
            q.setString("id", orderNum);
            count = q.executeUpdate();
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public void saveOrUpdateOrder(TabOrderTemp order) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(order);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
