package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.SeatsDao;
import com.spring.jersy.hibernate.model.entity.Seats;
import com.spring.jersy.hibernate.model.service.SeatsService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    private SeatsDao seatsDao;

    @Override
    public PageList findPageList(int page, int rows, String sort, String order, String key, Integer type, String begintime, String endtime, int clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Seats.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or name like '%" + key + "%' or extensionnum like '%" + key + "%')"));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }


        PageList pageList = new PageList(page, rows);
        pageList = seatsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public List<Seats> findList(String sort, String order, String key) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Seats.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or name like '%" + key + "%'or seatsnum like '%" + key + "%'or extensionnum like '%" + key + "%'or unit like '%" + key + "%')"));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        return seatsDao.findByDetachedCriteria(dc);
    }

    @Override
    public Seats findByid(Integer id) {
        return seatsDao.get(id);
    }

    @Override
    public Seats findByName(String name) {
        DetachedCriteria dc = DetachedCriteria.forClass(Seats.class);
        dc.add(Restrictions.eq("opruser", name));
        return seatsDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Seats findByAccount(String account) {
        DetachedCriteria dc = DetachedCriteria.forClass(Seats.class);
        dc.add(Restrictions.eq("account", account));
        return seatsDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Seats findByOpruser(String opruser) {
        DetachedCriteria dc = DetachedCriteria.forClass(Seats.class);
        dc.add(Restrictions.eq("opruser", opruser));
        return seatsDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Seats findBySeatlogin(String account, String pwd) {
        DetachedCriteria dc = DetachedCriteria.forClass(Seats.class);
        dc.add(Restrictions.eq("account", account));
        dc.add(Restrictions.eq("password", pwd));
        return seatsDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public Seats findByPhone(String phone) {
        return null;
    }

    @Override
    public void delete(String opruserid) {
        String sql = "DELETE FROM tab_seats WHERE account='" + opruserid + "'";
        seatsDao.updateSql(sql);
    }

    @Override
    public void save(Seats seats) {
        seatsDao.save(seats);
    }

    @Override
    public void saveOrUpd(Seats seats) {
        seatsDao.saveOrUpdate(seats);
    }
}
