package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperationsTimeCycleDao;
import com.spring.jersy.hibernate.model.entity.OperationsTimeCycle;
import com.spring.jersy.hibernate.model.service.OperationsTimeCycleService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperationsTimeCycleServiceImpl implements OperationsTimeCycleService {

    @Autowired
    private OperationsTimeCycleDao operationsTimeCycleDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperationsTimeCycle.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' or companyname like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            dc.add(Restrictions.ge("weeks", begintime));
        }

        if (!S.isNull(endtime)) {
            dc.add(Restrictions.le("weeks", endtime));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = operationsTimeCycleDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperationsTimeCycle findByid(Integer id) {
        return operationsTimeCycleDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operationsTimeCycleDao.delete(id);
    }

    @Override
    public void save(OperationsTimeCycle operationsTimeCycle) {
        operationsTimeCycleDao.save(operationsTimeCycle);
    }

    @Override
    public void saveOrUpd(OperationsTimeCycle operationsTimeCycle) {
        operationsTimeCycleDao.saveOrUpdate(operationsTimeCycle);
    }
}
