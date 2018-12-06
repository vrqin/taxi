package com.speedtalk.order.engine.dao;

import com.speedtalk.order.engine.db.HibernateSessionFactory;
import com.speedtalk.utils.ExcepPrinter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public class BaseDao {
    public Serializable save(Object object) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Serializable serializable = session.save(object);
            tx.commit();
            session.close();
            return serializable;
        } catch (Exception e) {
            ExcepPrinter.print(e);
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

    public void save(List<Object> list) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            for (Object object : list)
                session.save(object);
            tx.commit();
            session.close();
        } catch (Exception e) {
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
            throw e;
        }
    }

    public void saveOrUpdate(List<Object> list) throws Exception {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            for (Object object : list)
                session.saveOrUpdate(object);
            tx.commit();
            session.close();
        } catch (Exception e) {
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
            throw e;
        }
    }

    public boolean update(Object object) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.update(object);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            ExcepPrinter.print(e);
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
        return false;
    }

    public boolean delete(Object object) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.delete(object);
            tx.commit();
            session.close();
            return true;
        } catch (Exception e) {
            ExcepPrinter.print(e);
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
        return false;
    }

    public Object get(Class<?> c, Serializable id) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Object obj = session.get(c, id);
            tx.commit();
            session.close();
            return obj;
        } catch (Exception e) {
            ExcepPrinter.print(e);
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

    public List<Object> findByDetachedCriteria(DetachedCriteria dc) {
        Session session = null;
        List<Object> list = null;
        try {
            session = HibernateSessionFactory.getSession();
            Criteria criteria = dc.getExecutableCriteria(session);
            list = criteria.list();
            session.close();
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return list;
    }

    public Object findByDetachedCriteriaObj(DetachedCriteria dc) {
        Session session = null;
        List<Object> list = null;
        try {
            session = HibernateSessionFactory.getSession();
            Criteria criteria = dc.getExecutableCriteria(session);
            list = criteria.list();
            session.close();
        } catch (Exception e) {
            ExcepPrinter.print(e);
        }
        return null == list ? null : list.get(0);
    }
}
