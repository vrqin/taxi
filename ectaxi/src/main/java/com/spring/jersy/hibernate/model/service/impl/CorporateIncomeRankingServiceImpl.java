package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CorporateIncomeRankingDao;
import com.spring.jersy.hibernate.model.entity.CorporateIncomeRanking;
import com.spring.jersy.hibernate.model.service.CorporateIncomeRankingService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CorporateIncomeRankingServiceImpl implements CorporateIncomeRankingService {

    @Autowired
    private CorporateIncomeRankingDao corporateIncomeRankingDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CorporateIncomeRanking.class);

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
        pageList = corporateIncomeRankingDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CorporateIncomeRanking findByid(Integer id) {
        return corporateIncomeRankingDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        corporateIncomeRankingDao.delete(id);
    }

    @Override
    public void save(CorporateIncomeRanking corporateIncomeRanking) {
        corporateIncomeRankingDao.save(corporateIncomeRanking);
    }

    @Override
    public void saveOrUpd(CorporateIncomeRanking corporateIncomeRanking) {
        corporateIncomeRankingDao.saveOrUpdate(corporateIncomeRanking);
    }
}
