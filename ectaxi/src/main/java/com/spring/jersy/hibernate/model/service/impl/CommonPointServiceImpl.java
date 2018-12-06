package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CommonPointDao;
import com.spring.jersy.hibernate.model.entity.CommonPoint;
import com.spring.jersy.hibernate.model.service.CommonPointService;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
@Service
public class CommonPointServiceImpl implements CommonPointService {

    @Autowired
    private CommonPointDao commonPointDao;

    @Override
    public List<CommonPoint> findList(String sort, String order, String position, String phone, Integer type, String geographical, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CommonPoint.class);

        if (!S.isNull(position)) {
            dc.add(Restrictions.like("position", "%" + position + "%"));
        }
        if (!S.isNull(geographical)) {
            dc.add(Restrictions.like("geographical", "%" + geographical + "%"));
        }
        if (!S.isNull(phone)) {
            dc.add(Restrictions.like("phone", "%" + phone + "%"));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("type", type));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        return commonPointDao.findByDetachedCriteria(dc);
    }

    @Override
    public CommonPoint findByid(Integer id) {
        return commonPointDao.get(id);
    }

    @Override
    public CommonPoint findByGeographical(String phone, String geographical) {
        DetachedCriteria dc = DetachedCriteria.forClass(CommonPoint.class);

        if (!S.isNull(geographical)) {
            dc.add(Restrictions.eq("phone", phone));
        }

        if (!S.isNull(geographical)) {
            dc.add(Restrictions.eq("geographical", geographical));
        }

        return commonPointDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void delete(Integer id) {
        commonPointDao.delete(id);
    }

    @Override
    public void save(CommonPoint commonPoint) {
        commonPointDao.save(commonPoint);
    }

    @Override
    public void saveOrUpd(CommonPoint commonPoint) {
        commonPointDao.saveOrUpdate(commonPoint);
    }
}
