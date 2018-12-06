package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverEvaluationDao;
import com.spring.jersy.hibernate.model.entity.DriverEvaluation;
import com.spring.jersy.hibernate.model.service.DriverEvaluationService;
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
public class DriverEvaluationServiceImpl implements DriverEvaluationService {

    @Autowired
    private DriverEvaluationDao driverEvaluationDao;


    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverEvaluation.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(enterprisename like '%" + key + "%' or account like '%" + key + "%' or seniority like '%" + key + "%' or evaluationversion like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("evaluationtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("evaluationtime", end));
        }

        //        if (!S.isNull(type)){
        //            dc.add(Restrictions.eq("evaluationtype",type));
        //        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverEvaluationDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverEvaluation findByid(Integer id) {
        return driverEvaluationDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverEvaluationDao.delete(id);
    }

    @Override
    public void save(DriverEvaluation driverEvaluation) {
        driverEvaluationDao.save(driverEvaluation);
    }

    @Override
    public void saveOrUpd(DriverEvaluation driverEvaluation) {
        driverEvaluationDao.saveOrUpdate(driverEvaluation);
    }
}
