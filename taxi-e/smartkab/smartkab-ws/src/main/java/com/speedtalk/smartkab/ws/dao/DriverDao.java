package com.speedtalk.smartkab.ws.dao;

import com.speedtalk.smartkab.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.ws.db.TabDriver;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverDao {
    public Map<String, TabDriver> getDriverMap() {
        Map<String, TabDriver> map = new HashMap<String, TabDriver>();
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            List<TabDriver> list = session.createQuery(" from TabDriver").list();
            tx.commit();
            session.close();
            try {
                for (TabDriver driver : list)
                    map.put(driver.getAccount(), driver);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public TabDriver getDriver(String msId) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            TabDriver driver = (TabDriver) session.createQuery(" from TabDriver where msid=:id")
                    .setString("id", msId)
                    .uniqueResult();
            tx.commit();
            session.close();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TabDriver getDriverByAccount(String account) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            TabDriver driver = (TabDriver) session.createQuery(" from TabDriver where account=:account")
                    .setString("account", account)
                    .uniqueResult();
            tx.commit();
            session.close();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
