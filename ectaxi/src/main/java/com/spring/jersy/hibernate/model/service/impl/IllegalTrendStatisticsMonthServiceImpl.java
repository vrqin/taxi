package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.IllegalTrendStatisticsMonthDao;
import com.spring.jersy.hibernate.model.entity.IllegalTrendStatisticsMonth;
import com.spring.jersy.hibernate.model.service.IllegalTrendStatisticsMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IllegalTrendStatisticsMonthServiceImpl implements IllegalTrendStatisticsMonthService {

    @Autowired
    private IllegalTrendStatisticsMonthDao illegalTrendStatisticsMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(IllegalTrendStatisticsMonth.class);


        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("month", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("month", endtime));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = illegalTrendStatisticsMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public IllegalTrendStatisticsMonth findByid(Integer id) {
        return illegalTrendStatisticsMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        illegalTrendStatisticsMonthDao.delete(id);
    }

    @Override
    public void save(IllegalTrendStatisticsMonth illegalTrendStatisticsMonth) {
        illegalTrendStatisticsMonthDao.save(illegalTrendStatisticsMonth);
    }

    @Override
    public void saveOrUpd(IllegalTrendStatisticsMonth illegalTrendStatisticsMonth) {
        illegalTrendStatisticsMonthDao.saveOrUpdate(illegalTrendStatisticsMonth);
    }
}
