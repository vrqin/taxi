package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseIntegratedQueryDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseIntegratedQuery;
import com.spring.jersy.hibernate.model.service.EnterpriseIntegratedQueryService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseIntegratedQueryServiceImpl implements EnterpriseIntegratedQueryService {

    @Autowired
    private EnterpriseIntegratedQueryDao enterpriseIntegratedQueryDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseIntegratedQuery.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%' or area like '%" + key + "%'or totalincome like '%" + key + "%')"));
        }


        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = enterpriseIntegratedQueryDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseIntegratedQuery findByid(Integer id) {
        return enterpriseIntegratedQueryDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseIntegratedQueryDao.delete(id);
    }

    @Override
    public void save(EnterpriseIntegratedQuery enterpriseIntegratedQuery) {
        enterpriseIntegratedQueryDao.save(enterpriseIntegratedQuery);
    }

    @Override
    public void saveOrUpd(EnterpriseIntegratedQuery enterpriseIntegratedQuery) {
        enterpriseIntegratedQueryDao.saveOrUpdate(enterpriseIntegratedQuery);
    }
}
