package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarIncomeRankingDayDao;
import com.spring.jersy.hibernate.model.entity.CarIncomeRankingDay;
import com.spring.jersy.hibernate.model.service.CarIncomeRankingDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarIncomeRankingDayServiceImpl implements CarIncomeRankingDayService {

    @Autowired
    private CarIncomeRankingDayDao carIncomeRankingDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarIncomeRankingDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or companyname like '%" + key + "%'or kabnum like '%" + key + "%')"));
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
        pageList = carIncomeRankingDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarIncomeRankingDay findByid(Integer id) {
        return carIncomeRankingDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carIncomeRankingDayDao.delete(id);
    }

    @Override
    public void save(CarIncomeRankingDay carIncomeRankingDay) {
        carIncomeRankingDayDao.save(carIncomeRankingDay);
    }

    @Override
    public void saveOrUpd(CarIncomeRankingDay carIncomeRankingDay) {
        carIncomeRankingDayDao.saveOrUpdate(carIncomeRankingDay);
    }
}
