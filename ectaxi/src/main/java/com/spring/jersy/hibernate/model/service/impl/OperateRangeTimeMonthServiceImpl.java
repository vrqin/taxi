package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperateRangeTimeMonthDao;
import com.spring.jersy.hibernate.model.entity.OperateRangeTimeMonth;
import com.spring.jersy.hibernate.model.service.OperateRangeTimeMonthService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperateRangeTimeMonthServiceImpl implements OperateRangeTimeMonthService {

    @Autowired
    private OperateRangeTimeMonthDao operateRangeTimeMonthDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperateRangeTimeMonth.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' or companyname like '%" + key + "%')"));
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
        pageList = operateRangeTimeMonthDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperateRangeTimeMonth findByid(Integer id) {
        return operateRangeTimeMonthDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operateRangeTimeMonthDao.delete(id);
    }

    @Override
    public void save(OperateRangeTimeMonth operateRangeTimeMonth) {
        operateRangeTimeMonthDao.save(operateRangeTimeMonth);
    }

    @Override
    public void saveOrUpd(OperateRangeTimeMonth operateRangeTimeMonth) {
        operateRangeTimeMonthDao.saveOrUpdate(operateRangeTimeMonth);
    }
}
