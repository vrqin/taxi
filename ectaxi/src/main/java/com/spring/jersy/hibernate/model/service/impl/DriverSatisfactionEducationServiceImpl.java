package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverSatisfactionEducationDao;
import com.spring.jersy.hibernate.model.entity.DriverSatisfactionEducation;
import com.spring.jersy.hibernate.model.service.DriverSatisfactionEducationService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverSatisfactionEducationServiceImpl implements DriverSatisfactionEducationService {

    @Autowired
    private DriverSatisfactionEducationDao driverSatisfactionEducationDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverSatisfactionEducation.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' )"));
        }
        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("satistime", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("satistime", begintime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverSatisfactionEducationDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverSatisfactionEducation findByid(Integer id) {
        return driverSatisfactionEducationDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverSatisfactionEducationDao.delete(id);
    }

    @Override
    public void save(DriverSatisfactionEducation driverSatisfactionEducation) {
        driverSatisfactionEducationDao.save(driverSatisfactionEducation);
    }

    @Override
    public void saveOrUpd(DriverSatisfactionEducation driverSatisfactionEducation) {
        driverSatisfactionEducationDao.saveOrUpdate(driverSatisfactionEducation);
    }
}
