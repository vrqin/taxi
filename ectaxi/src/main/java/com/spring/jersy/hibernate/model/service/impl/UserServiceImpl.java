package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.UserDao;
import com.spring.jersy.hibernate.model.entity.User;
import com.spring.jersy.hibernate.model.service.UserService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/3/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public static StringBuffer UserInfoBySql(String key, int onoffline, int clientid) {
        StringBuffer sqllsit = new StringBuffer();

        sqllsit.append(" SELECT accountID,accountName,passwd,onlineStatus,userName,registerTime,remark,ClientId,roleid FROM `tab_user` ");
        if (clientid != 0) {
            sqllsit.append(" WHERE ClientId=" + clientid + " and (accountName LIKE '%" + key + "%' OR userName LIKE '%" + key + "%') ");
        } else {
            sqllsit.append(" WHERE  accountName LIKE '%" + key + "%' OR userName LIKE '%" + key + "%' ");
        }
        if (onoffline != -1) {
            sqllsit.append("  OR onlineStatus= " + onoffline);
        }
        return sqllsit;


    }

    @Override
    public User login(String username, String passwd) {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("accountName", username));
        dc.add(Restrictions.eq("passwd", passwd));
        return userDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public List<User> findList(String sort, String order, String key, Integer type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(accountName like '%" + key + "%')"));
        }

        if (!S.isNull(type)) {
            dc.add(Restrictions.eq("onlineStatus", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        return userDao.findByDetachedCriteria(dc);
    }

    @Override
    public User findByid(Integer userid) {
        return userDao.get(userid);
    }

    @Override
    public void delete(Integer userid) {
        userDao.delete(userid);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void saveOrUpd(User user) {
        userDao.saveOrUpdate(user);
    }

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(userName like '%" + key + "%' or accountName like '%" + key + "%'or remark like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("registerTime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("registerTime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("islock", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = userDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<User> findSqlList(String sort, String order, String key, Integer type, int clientid) throws Exception {
        StringBuffer sqllsit = UserInfoBySql(key, type, clientid);
        List<Object[]> list = userDao.findListSql(String.valueOf(sqllsit));
        List<User> callBusslist = new ArrayList<User>();
        User user;
        for (Object[] objects : list) {
            user = new User();
            user.setAccountID(objects[0] == null ? 0 : Integer.parseInt(objects[0].toString()));
            user.setAccountName(objects[1] == null ? " " : objects[1].toString());
            user.setPasswd(objects[2] == null ? " " : objects[2].toString());
            user.setOnlineStatus(objects[3] == null ? 0 : Integer.parseInt(objects[3].toString()));
            user.setUserName(objects[4] == null ? " " : objects[4].toString());
            user.setRegisterTime(objects[5] == null ? null : DateUtil.stringToDate(objects[5].toString(), "yyyy-MM-dd HH:mm:ss"));
            user.setRemark(objects[6] == null ? " " : objects[6].toString());
            user.setClientId(objects[7] == null ? 0 : Integer.parseInt(objects[7].toString()));
            user.setRoleid(objects[8] == null ? 0 : Integer.parseInt(objects[8].toString()));
            callBusslist.add(user);
        }
        return callBusslist;
    }

    @Override
    public User findUserByaccount(String account) {
        DetachedCriteria dc = DetachedCriteria.forClass(User.class);
        dc.add(Restrictions.eq("accountName", account));
        return userDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void deleteUserToPri(Integer id) {
        String sql = " DELETE FROM `tab_user_privilege` WHERE accountID =" + id;
        userDao.updateSql(sql);
    }
}
