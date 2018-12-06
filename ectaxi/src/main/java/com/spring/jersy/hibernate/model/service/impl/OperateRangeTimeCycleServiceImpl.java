package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperateRangeTimeCycleDao;
import com.spring.jersy.hibernate.model.entity.OperateRangeTimeCycle;
import com.spring.jersy.hibernate.model.service.OperateRangeTimeCycleService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperateRangeTimeCycleServiceImpl implements OperateRangeTimeCycleService {

    @Autowired
    private OperateRangeTimeCycleDao operateRangeTimeCycleDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperateRangeTimeCycle.class);

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
        pageList = operateRangeTimeCycleDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperateRangeTimeCycle findByid(Integer id) {
        return operateRangeTimeCycleDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operateRangeTimeCycleDao.delete(id);
    }

    @Override
    public void save(OperateRangeTimeCycle operateRangeTimeCycle) {
        operateRangeTimeCycleDao.save(operateRangeTimeCycle);
    }

    @Override
    public void saveOrUpd(OperateRangeTimeCycle operateRangeTimeCycle) {
        operateRangeTimeCycleDao.saveOrUpdate(operateRangeTimeCycle);
    }
}
