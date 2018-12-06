package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverComplaintsMonthDao;
import com.spring.jersy.hibernate.model.entity.DriverComplaintsMonth;
import com.spring.jersy.hibernate.model.service.DriverComplaintsMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverComplaintsMonthServiceImpl implements DriverComplaintsMonthService {

    @Autowired
    private DriverComplaintsMonthDao driverComplaintsMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverComplaintsMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( account like '%" + key + "%')"));
        }

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
        pageList = driverComplaintsMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverComplaintsMonth findByid(Integer id) {
        return driverComplaintsMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverComplaintsMonthDao.delete(id);
    }

    @Override
    public void save(DriverComplaintsMonth driverComplaintsMonth) {
        driverComplaintsMonthDao.save(driverComplaintsMonth);
    }

    @Override
    public void saveOrUpd(DriverComplaintsMonth driverComplaintsMonth) {
        driverComplaintsMonthDao.saveOrUpdate(driverComplaintsMonth);
    }
}
