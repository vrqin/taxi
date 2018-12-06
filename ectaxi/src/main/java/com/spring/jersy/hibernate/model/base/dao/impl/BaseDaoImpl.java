package com.spring.jersy.hibernate.model.base.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.BaseDao;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2016/1/9.
 */
@SuppressWarnings("unchecked")
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Transactional
public class BaseDaoImpl<T extends Serializable, ID extends Serializable> implements BaseDao<T, ID> {

    protected Class<T> entity;
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public BaseDaoImpl() {
    }

    public BaseDaoImpl(Class<T> entity) {
        this.entity = entity;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    // 增删改方法
    @Override
    public ID save(T model) {
        return (ID) getSession().save(model);
    }

    @Override
    public void saveOrUpdate(T model) {
        getSession().saveOrUpdate(model);

    }

    @Override
    public void update(T model) {
        getSession().update(model);
    }

    @Override
    public T merge(T model) {
        return (T) getSession().merge(model);
    }

    @Override
    public void delete(ID id) {
        getSession().delete(this.get(id));
        flush();
    }

    @Override
    public void deleteObject(T model) {
        getSession().delete(model);
        flush();
    }

    //单表单主键批量删除
    @Override
    public int delBatch(String table, Integer[] ints) {
        // String hql = "delete from '"+obj+"' where id in (:delid)";
        String sql = "delete from " + table + " where id in(:delid)";
        Session session = getSession();
        // Query query = getSession().createQuery(hql);
        // query.setParameterList("delid", ints);
        // int dels = query.executeUpdate();
        // tx.commit();

        Query query = session.createSQLQuery(sql);//session.getTransaction().commit();
        query.setParameterList("delid", ints);

        return query.executeUpdate();
    }

    @Override
    public int findNumberHql(String hql) {
        Query query = getSession().createQuery(hql);
        Number n = (Number) query.uniqueResult();
        return (!S.isNull(n)) ? n.intValue() : 0;
    }

    @Override
    public int findNumberSql(String sql) {
        Query query = getSession().createQuery(sql);
        Number n = (Number) query.uniqueResult();
        return (!S.isNull(n)) ? n.intValue() : 0;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public T findObjHql(String hql) {
        Query query = getSession().createQuery(hql);
        List list = query.list();
        return (list.isEmpty()) ? null : (T) list.get(0);
    }

    @Override
    public List<T> findListHql(String hql) {
        Query query = getSession().createQuery(hql);
        return query.list();
    }

    @Override
    public List findListSql(String sql) {
        return getSession().createSQLQuery(sql).list();
    }


    @Override
    public Object findObjSql(String sql, List objects) {
        Query query = getSession().createQuery(sql);
        if (objects != null && objects.size() > 0) {
            for (int i = 0; i < objects.size(); i++) {
                query.setParameter(i, objects.get(i));
            }
        }
        List items = query.list();
        return items.isEmpty() ? null : items.get(0);
    }

    @Override
    public int findCount(String sql) {
        Query query = getSession().createSQLQuery(sql);
        Number n = (Number) query.uniqueResult();
        return (!S.isNull(n)) ? n.intValue() : 0;
    }

    @Override
    public boolean updateSql(String sql) {
        Session session = getSession();
        Number n = session.createSQLQuery(sql).executeUpdate();
        return (!S.isNull(n) && n.intValue() > 0);
    }


    @Override
    public void updateSql(String sql, List objects) {
        Query query = getSession().createQuery(sql);
        if (objects != null && objects.size() > 0) {
            for (int i = 0; i < objects.size(); i++) {
                query.setParameter(i, objects.get(i));
            }

        }
        query.executeUpdate();
    }

    @Override
    public T get(ID id) {
        return (T) getSession().get(this.entity, id);
    }

    @Override
    public List<T> listAll() {
        return getSession().createCriteria(this.entity).list();
    }

    @Override
    public List<T> listAll(int pageNum, int pageSize) {
        Criteria criteria = getSession().createCriteria(this.entity);
        criteria.setFirstResult((pageNum - 1) * pageSize + 1);
        criteria.setMaxResults(pageSize);
        return (List<T>) criteria.list();
    }


    @Override
    public PageList findPageList(PageList pageList, DetachedCriteria dc) {
        Criteria ca = dc.getExecutableCriteria(getSession());
        Object objInt = ca.setProjection(Projections.rowCount()).uniqueResult();
        int startNum = pageList.getPageSize() * (pageList.getPagenow() - 1);
        ca.setProjection(null);
        List items = ca.setFirstResult(startNum).setMaxResults(pageList.getPageSize()).list();
        pageList.setList(items);
        pageList.setTotalRecord(Integer.parseInt(objInt.toString()));
        return pageList;
    }

    @Override
    public PageList findPageList(PageList pageList, String[] sql, List objects) {
        int startNum = pageList.getPageSize() * (pageList.getPagenow() - 1);
        Query qcount = getSession().createSQLQuery(sql[0]);
        if (objects != null && objects.size() > 0) {
            for (int i = 0; i < objects.size(); i++) {
                qcount.setParameter(i, objects.get(i));
            }
        }
        Number n = (Number) qcount.uniqueResult();
        Query query = getSession().createSQLQuery(sql[1]);
        if (objects != null && objects.size() > 0) {
            for (int i = 0; i < objects.size(); i++) {
                query.setParameter(i, objects.get(i));
            }
        }
        List items = query.setFirstResult(startNum).setMaxResults(pageList.getPageSize()).list();
        pageList.setList(items);
        pageList.setTotalRecord((S.isNull(n)) ? 0 : n.intValue());
        return pageList;
    }

    @Override
    public PageList findPageList(PageList pageList, String sql, List objects) {
        int startNum = pageList.getPageSize() * (pageList.getPagenow() - 1);

        Query query = getSession().createSQLQuery(sql);
        if (objects != null && objects.size() > 0) {
            for (int i = 0; i < objects.size(); i++) {
                query.setParameter(i, objects.get(i));
            }
        }
        List list = query.list();
        int total = null == list ? 0 : list.size();
        List items = query.setFirstResult(startNum).setMaxResults(pageList.getPageSize()).list();
        pageList.setList(items);
        pageList.setTotalRecord(total);
        return pageList;
    }

    @Override
    public PageList findPageList(PageList pageList, DetachedCriteria dc, String sort, String order) {
        Criteria criteria = dc.getExecutableCriteria(getSession());
        Object objInt = criteria.setProjection(Projections.rowCount()).uniqueResult();
        int startNum = pageList.getPageSize() * (pageList.getPagenow() - 1);
        criteria.setProjection(null);
        if (!S.isNull(order)) {
            criteria.addOrder(order.equals("desc") ? Order.desc(sort) : Order.asc(sort));
        }
        List items = criteria.setFirstResult(startNum).setMaxResults(pageList.getPageSize()).list();
        pageList.setList(items);
        pageList.setTotalRecord(Integer.parseInt(objInt.toString()));
        return pageList;
    }

    @Override
    public T findByDetachedCriteriaObj(DetachedCriteria dc) {
        Criteria criteria = dc.getExecutableCriteria(getSession());
        List items = criteria.list();
        return items.isEmpty() ? null : (T) items.get(0);
    }

    @Override
    public List findByDetachedCriteria(DetachedCriteria dc) {
        Criteria criteria = dc.getExecutableCriteria(getSession());
        return criteria.list();
    }


    @Override
    public List findByDetachedCriteria(DetachedCriteria dc, int maxResult) {
        Criteria criteria = dc.getExecutableCriteria(getSession());
        criteria.setMaxResults(maxResult);
        return criteria.list();
    }


    // 其他方法
    @Override
    public boolean exists(ID id) {
        return get(id) != null;
    }

    @Override
    public void flush() {
        getSession().flush();
    }

    @Override
    public void clear() {
        getSession().clear();
    }
}
