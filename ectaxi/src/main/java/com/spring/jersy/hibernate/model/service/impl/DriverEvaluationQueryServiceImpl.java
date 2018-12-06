package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverEvaluationQueryDao;
import com.spring.jersy.hibernate.model.entity.DriverEvaluationQuery;
import com.spring.jersy.hibernate.model.service.DriverEvaluationQueryService;
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
public class DriverEvaluationQueryServiceImpl implements DriverEvaluationQueryService {

    @Autowired
    private DriverEvaluationQueryDao driverEvaluationQueryDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverEvaluationQuery.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(account like '%" + key + "%' or enterprisename like '%" + key + "%' or evaluationversion like '%" + key + "%' or kabnum like '%" + key + "%'  or seniority like '%" + key + "%'    or evaluationyears like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("evaluationtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("evaluationtime", end));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("evaluationlevel", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverEvaluationQueryDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverEvaluationQuery findByid(Integer id) {
        return driverEvaluationQueryDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverEvaluationQueryDao.delete(id);
    }

    @Override
    public void save(DriverEvaluationQuery driverEvaluationQuery) {
        driverEvaluationQueryDao.save(driverEvaluationQuery);
    }

    @Override
    public void saveOrUpd(DriverEvaluationQuery driverEvaluationQuery) {
        driverEvaluationQueryDao.saveOrUpdate(driverEvaluationQuery);
    }
}
