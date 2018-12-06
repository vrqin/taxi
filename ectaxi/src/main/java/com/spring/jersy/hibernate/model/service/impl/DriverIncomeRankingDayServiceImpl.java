package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIncomeRankingDayDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeRankingDay;
import com.spring.jersy.hibernate.model.service.DriverIncomeRankingDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverIncomeRankingDayServiceImpl implements DriverIncomeRankingDayService {

    @Autowired
    private DriverIncomeRankingDayDao driverIncomeRankingDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIncomeRankingDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or kabnum like '%" + key + "%'or companyname like '%" + key + "%')"));
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
        pageList = driverIncomeRankingDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIncomeRankingDay findByid(Integer id) {
        return driverIncomeRankingDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIncomeRankingDayDao.delete(id);
    }

    @Override
    public void save(DriverIncomeRankingDay driverIncomeRankingDay) {
        driverIncomeRankingDayDao.save(driverIncomeRankingDay);
    }

    @Override
    public void saveOrUpd(DriverIncomeRankingDay driverIncomeRankingDay) {
        driverIncomeRankingDayDao.saveOrUpdate(driverIncomeRankingDay);
    }
}
