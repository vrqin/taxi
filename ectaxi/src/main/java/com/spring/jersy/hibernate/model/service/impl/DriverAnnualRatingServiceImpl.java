package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverAnnualRatingDao;
import com.spring.jersy.hibernate.model.entity.DriverAnnualRating;
import com.spring.jersy.hibernate.model.service.DriverAnnualRatingService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class DriverAnnualRatingServiceImpl implements DriverAnnualRatingService {

    @Autowired
    private DriverAnnualRatingDao driverAnnualRatingDao;

    @Override
    public List<DriverAnnualRating> findList(String sort, String order, String key, String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverAnnualRating.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%'or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        return driverAnnualRatingDao.findByDetachedCriteria(dc);
    }

    @Override
    public DriverAnnualRating findByid(Integer id) {
        return driverAnnualRatingDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverAnnualRatingDao.delete(id);
    }

    @Override
    public void save(DriverAnnualRating driverAnnualRating) {
        driverAnnualRatingDao.save(driverAnnualRating);
    }

    @Override
    public void saveOrUpd(DriverAnnualRating driverAnnualRating) {
        driverAnnualRatingDao.saveOrUpdate(driverAnnualRating);
    }
}