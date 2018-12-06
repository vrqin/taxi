package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.MileageIncomeAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.MileageIncomeAnalysisMonth;
import com.spring.jersy.hibernate.model.service.MileageIncomeAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MileageIncomeAnalysisMonthServiceImpl implements MileageIncomeAnalysisMonthService {

    @Autowired
    private MileageIncomeAnalysisMonthDao mileageIncomeAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(MileageIncomeAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' )"));
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
        pageList = mileageIncomeAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public MileageIncomeAnalysisMonth findByid(Integer id) {
        return mileageIncomeAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        mileageIncomeAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(MileageIncomeAnalysisMonth mileageIncomeAnalysisMonth) {
        mileageIncomeAnalysisMonthDao.save(mileageIncomeAnalysisMonth);
    }

    @Override
    public void saveOrUpd(MileageIncomeAnalysisMonth mileageIncomeAnalysisMonth) {
        mileageIncomeAnalysisMonthDao.saveOrUpdate(mileageIncomeAnalysisMonth);
    }
}
