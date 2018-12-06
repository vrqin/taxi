package com.speedtalk.smartkab.score.ws.dao;

import com.speedtalk.smartkab.score.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.score.ws.db.TabDriver;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DriverDao {
    public TabDriver getByMsId(String msId) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            TabDriver driver = (TabDriver) session.createQuery(" from TabDriver where msid=:id")
                    .setString("id", msId)
                    .uniqueResult();
            tx.commit();
            session.close();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return null;
    }

    public TabDriver getByAccount(String account) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            TabDriver driver = (TabDriver) session.createQuery(" from TabDriver where account=:account")
                    .setString("account", account)
                    .uniqueResult();
            tx.commit();
            session.close();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return null;
    }

    public TabDriver getByICcard(String iccard) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            TabDriver driver = (TabDriver) session.createQuery(" from TabDriver where drivercardid=:iccard")
                    .setString("iccard", iccard)
                    .uniqueResult();
            tx.commit();
            session.close();
            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return null;
    }

    public void update(TabDriver tabDriver) throws NullPointerException {
        Session session = null;
        Transaction tx = null;
        try {
            if (null == tabDriver)
                throw new NullPointerException("Driver info is null!");
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.update(tabDriver);
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }

    public void updateOnlineStatus(String account, byte isonline) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Query q = session.createQuery("update from TabDriver set isonline=:online where account=:account");
            q.setByte("online", isonline);
            q.setString("account", account);
            q.executeUpdate();
            tx.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
    }

    public long getMaxId() {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Query q = session.createSQLQuery("select max(id) from tab_driver");
            int maxId = (Integer) q.uniqueResult();
            tx.commit();
            session.close();
            return maxId;
        } catch (Exception e) {
            e.printStackTrace();

            session.close();

            tx.rollback();

            return 0;
        }
    }
}
