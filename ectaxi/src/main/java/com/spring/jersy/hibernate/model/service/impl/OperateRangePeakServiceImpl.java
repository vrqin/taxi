package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperateRangePeakDao;
import com.spring.jersy.hibernate.model.entity.OperateRangePeak;
import com.spring.jersy.hibernate.model.service.OperateRangePeakService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperateRangePeakServiceImpl implements OperateRangePeakService {

    @Autowired
    private OperateRangePeakDao operateRangePeakDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperateRangePeak.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(area like '%" + key + "%' or companyname like '%" + key + "%'or peakperiod like '%" + key + "%')"));
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
        pageList = operateRangePeakDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperateRangePeak findByid(Integer id) {
        return operateRangePeakDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operateRangePeakDao.delete(id);
    }

    @Override
    public void save(OperateRangePeak operateRangePeak) {
        operateRangePeakDao.save(operateRangePeak);
    }

    @Override
    public void saveOrUpd(OperateRangePeak operateRangePeak) {
        operateRangePeakDao.saveOrUpdate(operateRangePeak);
    }
}
