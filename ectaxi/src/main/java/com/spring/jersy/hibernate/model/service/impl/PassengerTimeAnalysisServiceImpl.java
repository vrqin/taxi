package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PassengerTimeAnalysisDao;
import com.spring.jersy.hibernate.model.entity.PassengerTimeAnalysis;
import com.spring.jersy.hibernate.model.service.PassengerTimeAnalysisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PassengerTimeAnalysisServiceImpl implements PassengerTimeAnalysisService {

    @Autowired
    private PassengerTimeAnalysisDao passengerTimeAnalysisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PassengerTimeAnalysis.class);

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
        pageList = passengerTimeAnalysisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public PassengerTimeAnalysis findByid(Integer id) {
        return passengerTimeAnalysisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        passengerTimeAnalysisDao.delete(id);
    }

    @Override
    public void save(PassengerTimeAnalysis passengerTimeAnalysis) {
        passengerTimeAnalysisDao.save(passengerTimeAnalysis);
    }

    @Override
    public void saveOrUpd(PassengerTimeAnalysis passengerTimeAnalysis) {
        passengerTimeAnalysisDao.saveOrUpdate(passengerTimeAnalysis);
    }
}
