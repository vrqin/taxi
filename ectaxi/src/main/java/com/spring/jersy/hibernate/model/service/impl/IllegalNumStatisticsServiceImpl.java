package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.IllegalNumStatisticsDao;
import com.spring.jersy.hibernate.model.entity.IllegalNumStatistics;
import com.spring.jersy.hibernate.model.service.IllegalNumStatisticsService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IllegalNumStatisticsServiceImpl implements IllegalNumStatisticsService {

    @Autowired
    private IllegalNumStatisticsDao illegalNumStatisticsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(IllegalNumStatistics.class);


        if (!S.isNull(begintime)) {
            dc.add(Restrictions.ge("illtime", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("illtime", endtime));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("illegaltype", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = illegalNumStatisticsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public IllegalNumStatistics findByid(Integer id) {
        return illegalNumStatisticsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        illegalNumStatisticsDao.delete(id);
    }

    @Override
    public void save(IllegalNumStatistics illegalNumStatistics) {
        illegalNumStatisticsDao.save(illegalNumStatistics);
    }

    @Override
    public void saveOrUpd(IllegalNumStatistics illegalNumStatistics) {
        illegalNumStatisticsDao.saveOrUpdate(illegalNumStatistics);
    }
}
