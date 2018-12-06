package com.spring.jersy.hibernate.model.base.dao;


import com.spring.jersy.hibernate.publics.util.PageList;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by Administrator on 2016/1/9.
 */
public interface BaseDao<T, ID> {
    //增删改操作
    ID save(T model);

    void saveOrUpdate(T model);

    void update(T model);

    T merge(T model);

    void delete(ID id);

    void deleteObject(T model);

    int delBatch(String table, Integer ints[]);

    //sql语句操作

    /**
     * HQL语句操作,返回数量
     *
     * @param hql HQL语句
     * @return 数量
     */
    int findNumberHql(String hql);

    /**
     * SQL语句操作,返回数量
     *
     * @param sql SQL语句
     * @return 数量
     */
    int findNumberSql(String sql);

    /**
     * HQL语句操作,返回List<T>
     *
     * @param hql HQL语句
     * @return 泛型对象的List集合
     */
    List<T> findListHql(String hql);

    /**
     * SQL语句操作,返回List
     *
     * @param sql SQL语句
     * @return 对象的List集合
     */
    List findListSql(String sql);


    /**
     * HQL语句操作,返回泛型对象
     *
     * @param hql HQL语句
     * @return 泛型对象
     */
    T findObjHql(String hql);

    /**
     * SQL语句操作,返回单一对象
     *
     * @param sql     SQL语句
     * @param objects SQL语句中的参数集合
     * @return Object对象
     */
    Object findObjSql(String sql, List objects);

    /**
     * 更新,删除,添加的SQL语句操作
     *
     * @param sql SQL语句
     * @return 是否成功
     */
    boolean updateSql(String sql);

    /**
     * 更新,删除,添加的SQL语句操作
     *
     * @param sql     SQL语句
     * @param objects SQL语句中的参数集合
     */
    void updateSql(String sql, List objects);

    //查询方法
    T get(ID id);

    List<T> listAll();

    List<T> listAll(int pageNum, int pageSize);

    T findByDetachedCriteriaObj(DetachedCriteria dc);

    PageList findPageList(PageList pageList, DetachedCriteria dc);

    PageList findPageList(PageList pageList, String[] sql, List objects);

    PageList findPageList(PageList pageList, String sql, List objects);

    PageList findPageList(PageList pageList, DetachedCriteria dc, String sort, String order);

    List findByDetachedCriteria(DetachedCriteria dc);

    List findByDetachedCriteria(DetachedCriteria dc, int maxResult);

    int findCount(String sql);


    //其他方法
    boolean exists(ID id);

    void flush();

    void clear();

}
