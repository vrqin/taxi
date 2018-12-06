package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.MileageIncomeAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.MileageIncomeAnalysisDay;
import com.spring.jersy.hibernate.model.service.MileageIncomeAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MileageIncomeAnalysisDayServiceImpl implements MileageIncomeAnalysisDayService {

    @Autowired
    private MileageIncomeAnalysisDayDao mileageIncomeAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(MileageIncomeAnalysisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' )"));
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
        pageList = mileageIncomeAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public MileageIncomeAnalysisDay findByid(Integer id) {
        return mileageIncomeAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        mileageIncomeAnalysisDayDao.delete(id);
    }

    @Override
    public void save(MileageIncomeAnalysisDay mileageIncomeAnalysisDay) {
        mileageIncomeAnalysisDayDao.save(mileageIncomeAnalysisDay);
    }

    @Override
    public void saveOrUpd(MileageIncomeAnalysisDay mileageIncomeAnalysisDay) {
        mileageIncomeAnalysisDayDao.saveOrUpdate(mileageIncomeAnalysisDay);
    }
}
