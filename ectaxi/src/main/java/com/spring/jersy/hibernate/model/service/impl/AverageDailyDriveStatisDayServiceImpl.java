package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AverageDailyDriveStatisDayDao;
import com.spring.jersy.hibernate.model.entity.AverageDailyDriveStatisDay;
import com.spring.jersy.hibernate.model.service.AverageDailyDriveStatisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AverageDailyDriveStatisDayServiceImpl implements AverageDailyDriveStatisDayService {

    @Autowired
    private AverageDailyDriveStatisDayDao averageDailyDriveStatisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AverageDailyDriveStatisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
        }

        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("date", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("date", endtime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = averageDailyDriveStatisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AverageDailyDriveStatisDay findByid(Integer id) {
        return averageDailyDriveStatisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        averageDailyDriveStatisDayDao.delete(id);
    }

    @Override
    public void save(AverageDailyDriveStatisDay averageDailyDriveStatisDay) {
        averageDailyDriveStatisDayDao.save(averageDailyDriveStatisDay);
    }

    @Override
    public void saveOrUpd(AverageDailyDriveStatisDay averageDailyDriveStatisDay) {
        averageDailyDriveStatisDayDao.saveOrUpdate(averageDailyDriveStatisDay);
    }
}
