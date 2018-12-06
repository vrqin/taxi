package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseComplaintsMonthDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseComplaintsMonth;
import com.spring.jersy.hibernate.model.service.EnterpriseComplaintsMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseComplaintsMonthServiceImpl implements EnterpriseComplaintsMonthService {

    @Autowired
    private EnterpriseComplaintsMonthDao enterpriseComplaintsMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseComplaintsMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( companyname like '%" + key + "%')"));
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
        pageList = enterpriseComplaintsMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseComplaintsMonth findByid(Integer id) {
        return enterpriseComplaintsMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseComplaintsMonthDao.delete(id);
    }

    @Override
    public void save(EnterpriseComplaintsMonth enterpriseComplaintsMonth) {
        enterpriseComplaintsMonthDao.save(enterpriseComplaintsMonth);
    }

    @Override
    public void saveOrUpd(EnterpriseComplaintsMonth enterpriseComplaintsMonth) {
        enterpriseComplaintsMonthDao.saveOrUpdate(enterpriseComplaintsMonth);
    }
}
