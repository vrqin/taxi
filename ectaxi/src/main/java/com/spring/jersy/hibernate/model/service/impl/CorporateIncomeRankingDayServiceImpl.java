package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CorporateIncomeRankingDayDao;
import com.spring.jersy.hibernate.model.entity.CorporateIncomeRankingDay;
import com.spring.jersy.hibernate.model.service.CorporateIncomeRankingDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CorporateIncomeRankingDayServiceImpl implements CorporateIncomeRankingDayService {

    @Autowired
    private CorporateIncomeRankingDayDao corporateIncomeRankingDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CorporateIncomeRankingDay.class);

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
        pageList = corporateIncomeRankingDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CorporateIncomeRankingDay findByid(Integer id) {
        return corporateIncomeRankingDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        corporateIncomeRankingDayDao.delete(id);
    }

    @Override
    public void save(CorporateIncomeRankingDay corporateIncomeRankingDay) {
        corporateIncomeRankingDayDao.save(corporateIncomeRankingDay);
    }

    @Override
    public void saveOrUpd(CorporateIncomeRankingDay corporateIncomeRankingDay) {
        corporateIncomeRankingDayDao.saveOrUpdate(corporateIncomeRankingDay);
    }
}
