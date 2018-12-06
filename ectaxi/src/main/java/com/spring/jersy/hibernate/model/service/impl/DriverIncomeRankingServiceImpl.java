package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIncomeRankingDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeRanking;
import com.spring.jersy.hibernate.model.service.DriverIncomeRankingService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverIncomeRankingServiceImpl implements DriverIncomeRankingService {

    @Autowired
    private DriverIncomeRankingDao driverIncomeRankingDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIncomeRanking.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or kabnum like '%" + key + "%'or companyname like '%" + key + "%')"));
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
        pageList = driverIncomeRankingDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIncomeRanking findByid(Integer id) {
        return driverIncomeRankingDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIncomeRankingDao.delete(id);
    }

    @Override
    public void save(DriverIncomeRanking driverIncomeRanking) {
        driverIncomeRankingDao.save(driverIncomeRanking);
    }

    @Override
    public void saveOrUpd(DriverIncomeRanking driverIncomeRanking) {
        driverIncomeRankingDao.saveOrUpdate(driverIncomeRanking);
    }
}
