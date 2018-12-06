package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.EnterpriseTipStatisDayDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseTipStatisDay;
import com.spring.jersy.hibernate.model.service.EnterpriseTipStatisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnterpriseTipStatisDayServiceImpl implements EnterpriseTipStatisDayService {

    @Autowired
    private EnterpriseTipStatisDayDao enterpriseTipStatisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(EnterpriseTipStatisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
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
        pageList = enterpriseTipStatisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public EnterpriseTipStatisDay findByid(Integer id) {
        return enterpriseTipStatisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        enterpriseTipStatisDayDao.delete(id);
    }

    @Override
    public void save(EnterpriseTipStatisDay enterpriseTipStatisDay) {
        enterpriseTipStatisDayDao.save(enterpriseTipStatisDay);
    }

    @Override
    public void saveOrUpd(EnterpriseTipStatisDay enterpriseTipStatisDay) {
        enterpriseTipStatisDayDao.saveOrUpdate(enterpriseTipStatisDay);
    }
}
