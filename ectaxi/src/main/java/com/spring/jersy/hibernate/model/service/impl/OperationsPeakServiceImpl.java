package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperationsPeakDao;
import com.spring.jersy.hibernate.model.entity.OperationsPeak;
import com.spring.jersy.hibernate.model.service.OperationsPeakService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperationsPeakServiceImpl implements OperationsPeakService {

    @Autowired
    private OperationsPeakDao operationsPeakDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperationsPeak.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' or area like '%" + key + "%'or peakperiod like '%" + key + "%')"));
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
        pageList = operationsPeakDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperationsPeak findByid(Integer id) {
        return operationsPeakDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operationsPeakDao.delete(id);
    }

    @Override
    public void save(OperationsPeak operationsPeak) {
        operationsPeakDao.save(operationsPeak);
    }

    @Override
    public void saveOrUpd(OperationsPeak operationsPeak) {
        operationsPeakDao.saveOrUpdate(operationsPeak);
    }
}
