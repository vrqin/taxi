package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseIntegrateStatisDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseIntegrateStatis;
import com.spring.jersy.hibernate.model.service.EnterpriseIntegrateStatisService;
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
public class EnterpriseIntegrateStatisServiceImpl implements EnterpriseIntegrateStatisService {

    @Autowired
    private EnterpriseIntegrateStatisDao enterpriseIntegrateStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseIntegrateStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%'or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }

        if (!S.isNull(type)) {
            dc.add(Restrictions.eq("type", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = enterpriseIntegrateStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseIntegrateStatis findByid(Integer id) {
        return enterpriseIntegrateStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseIntegrateStatisDao.delete(id);
    }

    @Override
    public void save(EnterpriseIntegrateStatis enterpriseIntegrateStatis) {
        enterpriseIntegrateStatisDao.save(enterpriseIntegrateStatis);
    }

    @Override
    public void saveOrUpd(EnterpriseIntegrateStatis enterpriseIntegrateStatis) {
        enterpriseIntegrateStatisDao.saveOrUpdate(enterpriseIntegrateStatis);
    }
}
