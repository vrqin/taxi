package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.TotalRevenueAnalysisDayDao;
import com.spring.jersy.hibernate.model.entity.TotalRevenueAnalysisDay;
import com.spring.jersy.hibernate.model.service.TotalRevenueAnalysisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TotalRevenueAnalysisDayServiceImpl implements TotalRevenueAnalysisDayService {

    @Autowired
    private TotalRevenueAnalysisDayDao totalRevenueAnalysisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(TotalRevenueAnalysisDay.class);


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
        pageList = totalRevenueAnalysisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public TotalRevenueAnalysisDay findByid(Integer id) {
        return totalRevenueAnalysisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        totalRevenueAnalysisDayDao.delete(id);
    }

    @Override
    public void save(TotalRevenueAnalysisDay totalRevenueAnalysisDay) {
        totalRevenueAnalysisDayDao.save(totalRevenueAnalysisDay);
    }

    @Override
    public void saveOrUpd(TotalRevenueAnalysisDay totalRevenueAnalysisDay) {
        totalRevenueAnalysisDayDao.saveOrUpdate(totalRevenueAnalysisDay);
    }
}