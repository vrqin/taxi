package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIncomeStatisDayDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeStatisDay;
import com.spring.jersy.hibernate.model.service.DriverIncomeStatisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverIncomeStatisDayServiceImpl implements DriverIncomeStatisDayService {

    @Autowired
    private DriverIncomeStatisDayDao driverIncomeStatisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIncomeStatisDay.class);


        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
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
        pageList = driverIncomeStatisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIncomeStatisDay findByid(Integer id) {
        return driverIncomeStatisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIncomeStatisDayDao.delete(id);
    }

    @Override
    public void save(DriverIncomeStatisDay driverIncomeStatisDay) {
        driverIncomeStatisDayDao.save(driverIncomeStatisDay);
    }

    @Override
    public void saveOrUpd(DriverIncomeStatisDay driverIncomeStatisDay) {
        driverIncomeStatisDayDao.saveOrUpdate(driverIncomeStatisDay);
    }
}
