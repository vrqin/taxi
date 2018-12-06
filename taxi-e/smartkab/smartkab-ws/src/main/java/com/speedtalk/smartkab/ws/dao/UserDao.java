package com.speedtalk.smartkab.ws.dao;

import com.speedtalk.smartkab.ws.db.HibernateSessionFactory;
import com.speedtalk.smartkab.ws.db.TabPhoneuser;
import com.speedtalk.smartkab.ws.db.TbUser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {
    public UserDao() {
    }

    public TbUser getUserByAccount(String account) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            TbUser user = (TbUser) session.createQuery(" from TbUser where " + "account=:at")
                    .setString("at", account)
                    .uniqueResult();
            tx.commit();
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TbUser getUserByAccount(String account, String pwd) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            TbUser user = (TbUser) session.createQuery(" from TbUser where " + "account=:at and pwd=:pwd")
                    .setString("at", account)
                    .setString("pwd", pwd)
                    .uniqueResult();
            tx.commit();
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TabPhoneuser getByAccount(String account) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            TabPhoneuser user = (TabPhoneuser) session.createQuery(" from TabPhoneuser where " + "opruser=:at")
                    .setString("at", account)
                    .uniqueResult();
            tx.commit();
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TabPhoneuser getByAccount(String account, String pwd) {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            TabPhoneuser user = (TabPhoneuser) session.createQuery(" from TabPhoneuser where " + "opruser=:at and password=:pwd")
                    .setString("at", account)
                    .setString("pwd", pwd)
                    .uniqueResult();
            tx.commit();
            session.close();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param user
     * @throws HibernateException
     */
    public void saveOrUpdate(TabPhoneuser user) throws HibernateException {
        try {
            Session session = HibernateSessionFactory.getSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
            session.close();
        } catch (HibernateException he) {
            throw he;
        }
    }
}
