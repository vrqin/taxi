package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.SetWarnThresholdDao;
import com.spring.jersy.hibernate.model.entity.SetWarnThreshold;
import com.spring.jersy.hibernate.model.service.SetWarnThresholdService;
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
public class SetWarnThresholdServiceImpl implements SetWarnThresholdService {

    @Autowired
    private SetWarnThresholdDao setWarnThresholdDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(SetWarnThreshold.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(versionname like '%" + key + "%' or versionyears like '%" + key + "%'or status like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("evaluationtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("evaluationtime", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = setWarnThresholdDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public SetWarnThreshold findByid(Integer id) {
        return setWarnThresholdDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        setWarnThresholdDao.delete(id);
    }

    @Override
    public void save(SetWarnThreshold setWarnThreshold) {
        setWarnThresholdDao.save(setWarnThreshold);
    }

    @Override
    public void saveOrUpd(SetWarnThreshold setWarnThreshold) {
        setWarnThresholdDao.saveOrUpdate(setWarnThreshold);
    }
}
