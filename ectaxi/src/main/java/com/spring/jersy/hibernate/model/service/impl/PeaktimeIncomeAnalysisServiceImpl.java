package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PeaktimeIncomeAnalysisDao;
import com.spring.jersy.hibernate.model.entity.PeaktimeIncomeAnalysis;
import com.spring.jersy.hibernate.model.service.PeaktimeIncomeAnalysisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PeaktimeIncomeAnalysisServiceImpl implements PeaktimeIncomeAnalysisService {

    @Autowired
    private PeaktimeIncomeAnalysisDao peaktimeIncomeAnalysisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PeaktimeIncomeAnalysis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  companyname like '%" + key + "%')"));
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
        pageList = peaktimeIncomeAnalysisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PeaktimeIncomeAnalysis findByid(Integer id) {
        return peaktimeIncomeAnalysisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        peaktimeIncomeAnalysisDao.delete(id);
    }

    @Override
    public void save(PeaktimeIncomeAnalysis peaktimeIncomeAnalysis) {
        peaktimeIncomeAnalysisDao.save(peaktimeIncomeAnalysis);
    }

    @Override
    public void saveOrUpd(PeaktimeIncomeAnalysis peaktimeIncomeAnalysis) {
        peaktimeIncomeAnalysisDao.saveOrUpdate(peaktimeIncomeAnalysis);
    }
}
