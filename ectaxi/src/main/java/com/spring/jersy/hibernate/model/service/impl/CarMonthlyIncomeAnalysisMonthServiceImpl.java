package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarMonthlyIncomeAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.CarMonthlyIncomeAnalysisMonth;
import com.spring.jersy.hibernate.model.service.CarMonthlyIncomeAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarMonthlyIncomeAnalysisMonthServiceImpl implements CarMonthlyIncomeAnalysisMonthService {

    @Autowired
    private CarMonthlyIncomeAnalysisMonthDao carMonthlyIncomeAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarMonthlyIncomeAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
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
        pageList = carMonthlyIncomeAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarMonthlyIncomeAnalysisMonth findByid(Integer id) {
        return carMonthlyIncomeAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carMonthlyIncomeAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(CarMonthlyIncomeAnalysisMonth carMonthlyIncomeAnalysisMonth) {
        carMonthlyIncomeAnalysisMonthDao.save(carMonthlyIncomeAnalysisMonth);
    }

    @Override
    public void saveOrUpd(CarMonthlyIncomeAnalysisMonth carMonthlyIncomeAnalysisMonth) {
        carMonthlyIncomeAnalysisMonthDao.saveOrUpdate(carMonthlyIncomeAnalysisMonth);
    }
}
