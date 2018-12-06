package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.RegionalPoliceStatisDao;
import com.spring.jersy.hibernate.model.entity.RegionalPoliceStatis;
import com.spring.jersy.hibernate.model.service.RegionalPoliceStatisService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class RegionalPoliceStatisServiceImpl implements RegionalPoliceStatisService {

    @Autowired
    private RegionalPoliceStatisDao regionalPoliceStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(RegionalPoliceStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or driver like '%" + key + "%'or unit like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }

        if (!S.isNull(type)) {
            dc.add(Restrictions.eq("type", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = regionalPoliceStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public RegionalPoliceStatis findByid(Integer id) {
        return regionalPoliceStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        regionalPoliceStatisDao.delete(id);
    }

    @Override
    public void save(RegionalPoliceStatis regionalPoliceStatis) {
        regionalPoliceStatisDao.save(regionalPoliceStatis);
    }

    @Override
    public void saveOrUpd(RegionalPoliceStatis regionalPoliceStatis) {
        regionalPoliceStatisDao.saveOrUpdate(regionalPoliceStatis);
    }
}
