package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AverageDailyDriveStatisYearDao;
import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisYear;
import com.spring.jersy.hibernate.model.service.AverageDailyDriveStatisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AverageDailyDriveStatisYearServiceImpl implements AverageDailyDriveStatisYearService {

    @Autowired
    private AverageDailyDriveStatisYearDao averageDailyDriveStatisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AverageDailyDriveStatisYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
        }

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
        pageList = averageDailyDriveStatisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AverageDailyDriveStatisYear findByid(Integer id) {
        return averageDailyDriveStatisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        averageDailyDriveStatisYearDao.delete(id);
    }

    @Override
    public void save(AverageDailyDriveStatisYear averageDailyDriveStatisYear) {
        averageDailyDriveStatisYearDao.save(averageDailyDriveStatisYear);
    }

    @Override
    public void saveOrUpd(AverageDailyDriveStatisYear averageDailyDriveStatisYear) {
        averageDailyDriveStatisYearDao.saveOrUpdate(averageDailyDriveStatisYear);
    }
}
