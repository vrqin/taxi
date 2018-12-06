package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PeaktimeIncomeAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysisDay;
import com.spring.jersy.hibernate.model.service.PeaktimeIncomeAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeaktimeIncomeAnalysisDayServiceImpl implements PeaktimeIncomeAnalysisDayService {

    @Autowired
    private PeaktimeIncomeAnalysisDayDao peaktimeIncomeAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PeaktimeIncomeAnalysisDay.class);

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
        pageList = peaktimeIncomeAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PeaktimeIncomeAnalysisDay findByid(Integer id) {
        return peaktimeIncomeAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        peaktimeIncomeAnalysisDayDao.delete(id);
    }

    @Override
    public void save(PeaktimeIncomeAnalysisDay peaktimeIncomeAnalysisDay) {
        peaktimeIncomeAnalysisDayDao.save(peaktimeIncomeAnalysisDay);
    }

    @Override
    public void saveOrUpd(PeaktimeIncomeAnalysisDay peaktimeIncomeAnalysisDay) {
        peaktimeIncomeAnalysisDayDao.saveOrUpdate(peaktimeIncomeAnalysisDay);
    }
}
