package com.speedtalk.smartkab.ws.dao;

import com.speedtalk.smartkab.ws.db.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.ArrayList;
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

    public Object findObjByDetachedCriteria(DetachedCriteria dc) {
        Session session = null;
        try {
            session = HibernateSessionFactory.getSession();
            Criteria criteria = dc.getExecutableCriteria(session);
            List<Object> items = criteria.list();
            return items.isEmpty() ? null : items.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (Exception e2) {
            }
        }
        return null;
    }

    public List<Object> findListByDetachedCriteria(DetachedCriteria dc) {
        List<Object> list = new ArrayList<Object>();
        Session session = null;
        try {
            session = HibernateSessionFactory.getSession();
            Criteria criteria = dc.getExecutableCriteria(session);
            list = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                session.close();
            } catch (Exception e2) {
            }
        }
        return list;
    }

    public List<Object[]> findBySql(String sql) {
        Session session = null;
        List<Object[]> list = null;
        try {
            session = HibernateSessionFactory.getSession();
            Query q = session.createSQLQuery(sql);
            list = q.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
