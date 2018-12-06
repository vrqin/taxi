package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.MileageIncomeAnalysisYearDao;
import com.spring.jersy.hibernate.model.entity.MileageIncomeAnalysisYear;
import com.spring.jersy.hibernate.model.service.MileageIncomeAnalysisYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MileageIncomeAnalysisYearServiceImpl implements MileageIncomeAnalysisYearService {

    @Autowired
    private MileageIncomeAnalysisYearDao mileageIncomeAnalysisYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(MileageIncomeAnalysisYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' )"));
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
        pageList = mileageIncomeAnalysisYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public MileageIncomeAnalysisYear findByid(Integer id) {
        return mileageIncomeAnalysisYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        mileageIncomeAnalysisYearDao.delete(id);
    }

    @Override
    public void save(MileageIncomeAnalysisYear mileageIncomeAnalysisYear) {
        mileageIncomeAnalysisYearDao.save(mileageIncomeAnalysisYear);
    }

    @Override
    public void saveOrUpd(MileageIncomeAnalysisYear mileageIncomeAnalysisYear) {
        mileageIncomeAnalysisYearDao.saveOrUpdate(mileageIncomeAnalysisYear);
    }
}
