package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PassenIntegrityDao;
import com.spring.jersy.hibernate.model.entity.PassenIntegrity;
import com.spring.jersy.hibernate.model.service.PassenIntegrityService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/10.
 */
@Service
public class PassenIntegrityServiceImpl implements PassenIntegrityService {

    @Autowired
    private PassenIntegrityDao passenIntegrityDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, Integer isblacklist, String begintime, String endtime, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PassenIntegrity.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%'or remark like '%" + key + "%')"));
        }

        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("registrationtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("registrationtime", end));
        }
        if (!S.isNull(isblacklist)) {
            dc.add(Restrictions.eq("isblacklist", isblacklist));
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
        pageList = passenIntegrityDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PassenIntegrity findPassenIntegrityByPhone(String phone) {
        DetachedCriteria dc = DetachedCriteria.forClass(PassenIntegrity.class);
        dc.add(Restrictions.eq("phone", phone));
        return passenIntegrityDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void saveOrUpd(PassenIntegrity passenIntegrity) {
        passenIntegrityDao.saveOrUpdate(passenIntegrity);
    }


}
