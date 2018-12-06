package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseAnnualRatingDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseAnnualRating;
import com.spring.jersy.hibernate.model.service.EnterpriseAnnualRatingService;
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
public class EnterpriseAnnualRatingServiceImpl implements EnterpriseAnnualRatingService {

    @Autowired
    private EnterpriseAnnualRatingDao enterpriseAnnualRatingDao;

    @Override
    public List<EnterpriseAnnualRating> findList(String sort, String order, String key, String begintime, String endtime) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseAnnualRating.class);

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
        return enterpriseAnnualRatingDao.findByDetachedCriteria(dc);
    }

    @Override
    public EnterpriseAnnualRating findByid(Integer id) {
        return enterpriseAnnualRatingDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseAnnualRatingDao.delete(id);
    }

    @Override
    public void save(EnterpriseAnnualRating enterpriseAnnualRating) {
        enterpriseAnnualRatingDao.save(enterpriseAnnualRating);
    }

    @Override
    public void saveOrUpd(EnterpriseAnnualRating enterpriseAnnualRating) {
        enterpriseAnnualRatingDao.saveOrUpdate(enterpriseAnnualRating);
    }
}
