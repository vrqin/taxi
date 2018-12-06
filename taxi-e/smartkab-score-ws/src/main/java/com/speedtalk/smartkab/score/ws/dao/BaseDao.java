package com.speedtalk.smartkab.score.ws.dao;

import com.speedtalk.smartkab.score.ws.db.HibernateSessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class BaseDao {
    public static String replaceSQLKeyword(String input) {
        try {
            return input.replaceAll("(?!)delete|(?!)select|(?!)update|(?!)alter|(?!)modify", "");
        } catch (Exception e) {
        }
        return null;
    }

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
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
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
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
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
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
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
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
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
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
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
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
            }
        }
        return null;
    }

    public List<Object[]> get(String sql) {
        Session session = null;
        Transaction tx = null;
        List<Object[]> list = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            Query q = session.createSQLQuery(sql);
            list = q.list();
            tx.commit();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.close();
            } catch (Exception e2) {
            }
            try {
                tx.rollback();
            } catch (Exception e2) {
            }
        }
        return null;
    }
}
