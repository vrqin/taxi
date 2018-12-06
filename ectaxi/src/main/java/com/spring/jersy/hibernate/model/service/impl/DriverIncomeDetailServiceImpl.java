package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverIncomeDetailDao;
import com.spring.jersy.hibernate.model.entity.DriverIncomeDetail;
import com.spring.jersy.hibernate.model.service.DriverIncomeDetailService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverIncomeDetailServiceImpl implements DriverIncomeDetailService {

    @Autowired
    private DriverIncomeDetailDao driverIncomeDetailDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverIncomeDetail.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%'or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("date", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("date", begintime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverIncomeDetailDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverIncomeDetail findByid(Integer id) {
        return driverIncomeDetailDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverIncomeDetailDao.delete(id);
    }

    @Override
    public void save(DriverIncomeDetail driverIncomeDetail) {
        driverIncomeDetailDao.save(driverIncomeDetail);
    }

    @Override
    public void saveOrUpd(DriverIncomeDetail driverIncomeDetail) {
        driverIncomeDetailDao.saveOrUpdate(driverIncomeDetail);
    }
}
