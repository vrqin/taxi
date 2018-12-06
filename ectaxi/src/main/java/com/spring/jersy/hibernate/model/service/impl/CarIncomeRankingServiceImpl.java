package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarIncomeRankingDao;
import com.spring.jersy.hibernate.model.entity.CarIncomeRanking;
import com.spring.jersy.hibernate.model.service.CarIncomeRankingService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarIncomeRankingServiceImpl implements CarIncomeRankingService {

    @Autowired
    private CarIncomeRankingDao carIncomeRankingDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarIncomeRanking.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or companyname like '%" + key + "%'or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("month", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("month", endtime));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = carIncomeRankingDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarIncomeRanking findByid(Integer id) {
        return carIncomeRankingDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carIncomeRankingDao.delete(id);
    }

    @Override
    public void save(CarIncomeRanking carIncomeRanking) {
        carIncomeRankingDao.save(carIncomeRanking);
    }

    @Override
    public void saveOrUpd(CarIncomeRanking carIncomeRanking) {
        carIncomeRankingDao.saveOrUpdate(carIncomeRanking);
    }
}
