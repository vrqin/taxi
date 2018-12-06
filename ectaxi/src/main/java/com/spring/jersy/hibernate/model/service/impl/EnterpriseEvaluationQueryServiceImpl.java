package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseEvaluationQueryDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseEvaluationQuery;
import com.spring.jersy.hibernate.model.service.EnterpriseEvaluationQueryService;
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
public class EnterpriseEvaluationQueryServiceImpl implements EnterpriseEvaluationQueryService {

    @Autowired
    private EnterpriseEvaluationQueryDao enterpriseEvaluationQueryDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int level) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseEvaluationQuery.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(enterprisename like '%" + key + "'%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("evaluationtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("evaluationtime", end));
        }

        if (level > (-1)) {
            dc.add(Restrictions.eq("evaluationlevel", level));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = enterpriseEvaluationQueryDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseEvaluationQuery findByid(Integer id) {
        return enterpriseEvaluationQueryDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseEvaluationQueryDao.delete(id);
    }

    @Override
    public void save(EnterpriseEvaluationQuery enterpriseEvaluationQuery) {
        enterpriseEvaluationQueryDao.save(enterpriseEvaluationQuery);
    }

    @Override
    public void saveOrUpd(EnterpriseEvaluationQuery enterpriseEvaluationQuery) {
        enterpriseEvaluationQueryDao.saveOrUpdate(enterpriseEvaluationQuery);
    }
}
