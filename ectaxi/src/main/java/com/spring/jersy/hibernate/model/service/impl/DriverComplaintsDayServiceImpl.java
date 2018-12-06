package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverComplaintsDayDao;
import com.spring.jersy.hibernate.model.entity.DriverComplaintsDay;
import com.spring.jersy.hibernate.model.service.DriverComplaintsDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverComplaintsDayServiceImpl implements DriverComplaintsDayService {

    @Autowired
    private DriverComplaintsDayDao driverComplaintsDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverComplaintsDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("( account like '%" + key + "%')"));
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
        pageList = driverComplaintsDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverComplaintsDay findByid(Integer id) {
        return driverComplaintsDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverComplaintsDayDao.delete(id);
    }

    @Override
    public void save(DriverComplaintsDay driverComplaintsDay) {
        driverComplaintsDayDao.save(driverComplaintsDay);
    }

    @Override
    public void saveOrUpd(DriverComplaintsDay driverComplaintsDay) {
        driverComplaintsDayDao.saveOrUpdate(driverComplaintsDay);
    }
}
