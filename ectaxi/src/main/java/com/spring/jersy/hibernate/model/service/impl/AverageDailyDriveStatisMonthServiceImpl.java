package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AverageDailyDriveStatisMonthDao;
import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisMonth;
import com.spring.jersy.hibernate.model.service.AverageDailyDriveStatisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AverageDailyDriveStatisMonthServiceImpl implements AverageDailyDriveStatisMonthService {

    @Autowired
    private AverageDailyDriveStatisMonthDao averageDailyDriveStatisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String annual, int cycle, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AverageDailyDriveStatisMonth.class);


        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
        }

        if (!S.isNull(annual)) {

            dc.add(Restrictions.eq("annual", annual));
        }

        if (cycle > 0) {

            dc.add(Restrictions.eq("cycle", cycle));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = averageDailyDriveStatisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AverageDailyDriveStatisMonth findByid(Integer id) {
        return averageDailyDriveStatisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        averageDailyDriveStatisMonthDao.delete(id);
    }

    @Override
    public void save(AverageDailyDriveStatisMonth averageDailyDriveStatisMonth) {
        averageDailyDriveStatisMonthDao.save(averageDailyDriveStatisMonth);
    }

    @Override
    public void saveOrUpd(AverageDailyDriveStatisMonth averageDailyDriveStatisMonth) {
        averageDailyDriveStatisMonthDao.saveOrUpdate(averageDailyDriveStatisMonth);
    }
}
