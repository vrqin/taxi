package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CallstationDao;
import com.spring.jersy.hibernate.model.entity.Callstation;
import com.spring.jersy.hibernate.model.service.CallstationService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/9.
 */
@Service
public class CallstationServiceImpl implements CallstationService {

    @Autowired
    private CallstationDao callstationDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String position, String phone, int clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Callstation.class);

        if (!S.isNull(position)) {
            dc.add(Restrictions.like("position", "%" + position + "%"));
        }

        if (!S.isNull(phone)) {
            dc.add(Restrictions.like("phone", "%" + phone + "%"));
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
        pageList = callstationDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Callstation findByid(Integer id) {
        return callstationDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        callstationDao.delete(id);
    }

    @Override
    public void save(Callstation callstation) {
        callstationDao.save(callstation);
    }

    @Override
    public void saveOrUpd(Callstation callstation) {
        callstationDao.saveOrUpdate(callstation);
    }
}
