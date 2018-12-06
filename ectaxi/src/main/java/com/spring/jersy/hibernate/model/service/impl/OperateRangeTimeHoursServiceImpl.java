package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperateRangeTimeHoursDao;
import com.spring.jersy.hibernate.model.entity.OperateRangeTimeHours;
import com.spring.jersy.hibernate.model.service.OperateRangeTimeHoursService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class OperateRangeTimeHoursServiceImpl implements OperateRangeTimeHoursService {

    @Autowired
    private OperateRangeTimeHoursDao operateRangeTimeHoursDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperateRangeTimeHours.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' or companyname like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("hourse", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("hourse", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = operateRangeTimeHoursDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperateRangeTimeHours findByid(Integer id) {
        return operateRangeTimeHoursDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operateRangeTimeHoursDao.delete(id);
    }

    @Override
    public void save(OperateRangeTimeHours operateRangeTimeHours) {
        operateRangeTimeHoursDao.save(operateRangeTimeHours);
    }

    @Override
    public void saveOrUpd(OperateRangeTimeHours operateRangeTimeHours) {
        operateRangeTimeHoursDao.saveOrUpdate(operateRangeTimeHours);
    }
}
