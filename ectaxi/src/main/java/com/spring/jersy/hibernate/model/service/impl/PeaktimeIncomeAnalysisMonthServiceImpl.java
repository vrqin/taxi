package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PeaktimeIncomeAnalysisMonthDao;
import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysisMonth;
import com.spring.jersy.hibernate.model.service.PeaktimeIncomeAnalysisMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeaktimeIncomeAnalysisMonthServiceImpl implements PeaktimeIncomeAnalysisMonthService {

    @Autowired
    private PeaktimeIncomeAnalysisMonthDao peaktimeIncomeAnalysisMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PeaktimeIncomeAnalysisMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  companyname like '%" + key + "%')"));
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
        pageList = peaktimeIncomeAnalysisMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PeaktimeIncomeAnalysisMonth findByid(Integer id) {
        return peaktimeIncomeAnalysisMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        peaktimeIncomeAnalysisMonthDao.delete(id);
    }

    @Override
    public void save(PeaktimeIncomeAnalysisMonth peaktimeIncomeAnalysisMonth) {
        peaktimeIncomeAnalysisMonthDao.save(peaktimeIncomeAnalysisMonth);
    }

    @Override
    public void saveOrUpd(PeaktimeIncomeAnalysisMonth peaktimeIncomeAnalysisMonth) {
        peaktimeIncomeAnalysisMonthDao.saveOrUpdate(peaktimeIncomeAnalysisMonth);
    }
}