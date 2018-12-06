package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.IllegalTrendStatisticsYearDao;
import com.spring.jersy.hibernate.model.entity.IllegalTrendStatisticsYear;
import com.spring.jersy.hibernate.model.service.IllegalTrendStatisticsYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IllegalTrendStatisticsYearServiceImpl implements IllegalTrendStatisticsYearService {

    @Autowired
    private IllegalTrendStatisticsYearDao illegalTrendStatisticsYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(IllegalTrendStatisticsYear.class);


        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("annual", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("annual", endtime));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = illegalTrendStatisticsYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public IllegalTrendStatisticsYear findByid(Integer id) {
        return illegalTrendStatisticsYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        illegalTrendStatisticsYearDao.delete(id);
    }

    @Override
    public void save(IllegalTrendStatisticsYear illegalTrendStatisticsYear) {
        illegalTrendStatisticsYearDao.save(illegalTrendStatisticsYear);
    }

    @Override
    public void saveOrUpd(IllegalTrendStatisticsYear illegalTrendStatisticsYear) {
        illegalTrendStatisticsYearDao.saveOrUpdate(illegalTrendStatisticsYear);
    }
}
