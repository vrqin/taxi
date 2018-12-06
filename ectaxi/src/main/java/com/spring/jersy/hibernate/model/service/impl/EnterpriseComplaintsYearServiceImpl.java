package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseComplaintsYearDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseComplaintsYear;
import com.spring.jersy.hibernate.model.service.EnterpriseComplaintsYearService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseComplaintsYearServiceImpl implements EnterpriseComplaintsYearService {

    @Autowired
    private EnterpriseComplaintsYearDao enterpriseComplaintsYearDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseComplaintsYear.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( companyname like '%" + key + "%')"));
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
        pageList = enterpriseComplaintsYearDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseComplaintsYear findByid(Integer id) {
        return enterpriseComplaintsYearDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseComplaintsYearDao.delete(id);
    }

    @Override
    public void save(EnterpriseComplaintsYear enterpriseComplaintsYear) {
        enterpriseComplaintsYearDao.save(enterpriseComplaintsYear);
    }

    @Override
    public void saveOrUpd(EnterpriseComplaintsYear enterpriseComplaintsYear) {
        enterpriseComplaintsYearDao.saveOrUpdate(enterpriseComplaintsYear);
    }
}
