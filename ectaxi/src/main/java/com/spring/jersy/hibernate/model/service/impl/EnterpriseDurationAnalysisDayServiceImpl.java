package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseDurationAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseDurationAnalysisDay;
import com.spring.jersy.hibernate.model.service.EnterpriseDurationAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseDurationAnalysisDayServiceImpl implements EnterpriseDurationAnalysisDayService {

    @Autowired
    private EnterpriseDurationAnalysisDayDao enterpriseDurationAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseDurationAnalysisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  companyname like '%" + key + "%')"));
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
        pageList = enterpriseDurationAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseDurationAnalysisDay findByid(Integer id) {
        return enterpriseDurationAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseDurationAnalysisDayDao.delete(id);
    }

    @Override
    public void save(EnterpriseDurationAnalysisDay enterpriseDurationAnalysisDay) {
        enterpriseDurationAnalysisDayDao.save(enterpriseDurationAnalysisDay);
    }

    @Override
    public void saveOrUpd(EnterpriseDurationAnalysisDay enterpriseDurationAnalysisDay) {
        enterpriseDurationAnalysisDayDao.saveOrUpdate(enterpriseDurationAnalysisDay);
    }
}
