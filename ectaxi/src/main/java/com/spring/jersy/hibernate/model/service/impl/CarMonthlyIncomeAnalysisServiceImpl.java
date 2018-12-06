package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarMonthlyIncomeAnalysisDao;
import com.spring.jersy.hibernate.model.entity.CarMonthlyIncomeAnalysis;
import com.spring.jersy.hibernate.model.service.CarMonthlyIncomeAnalysisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarMonthlyIncomeAnalysisServiceImpl implements CarMonthlyIncomeAnalysisService {

    @Autowired
    private CarMonthlyIncomeAnalysisDao carMonthlyIncomeAnalysisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarMonthlyIncomeAnalysis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
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
        pageList = carMonthlyIncomeAnalysisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarMonthlyIncomeAnalysis findByid(Integer id) {
        return carMonthlyIncomeAnalysisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carMonthlyIncomeAnalysisDao.delete(id);
    }

    @Override
    public void save(CarMonthlyIncomeAnalysis carMonthlyIncomeAnalysis) {
        carMonthlyIncomeAnalysisDao.save(carMonthlyIncomeAnalysis);
    }

    @Override
    public void saveOrUpd(CarMonthlyIncomeAnalysis carMonthlyIncomeAnalysis) {
        carMonthlyIncomeAnalysisDao.saveOrUpdate(carMonthlyIncomeAnalysis);
    }
}
