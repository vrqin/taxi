package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseCarStatisDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCarStatis;
import com.spring.jersy.hibernate.model.service.EnterpriseCarStatisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseCarStatisServiceImpl implements EnterpriseCarStatisService {

    @Autowired
    private EnterpriseCarStatisDao enterpriseCarStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseCarStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(companyname like '%" + key + "%')"));
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
        pageList = enterpriseCarStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseCarStatis findByid(Integer id) {
        return enterpriseCarStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseCarStatisDao.delete(id);
    }

    @Override
    public void save(EnterpriseCarStatis enterpriseCarStatis) {
        enterpriseCarStatisDao.save(enterpriseCarStatis);
    }

    @Override
    public void saveOrUpd(EnterpriseCarStatis enterpriseCarStatis) {
        enterpriseCarStatisDao.saveOrUpdate(enterpriseCarStatis);
    }
}
