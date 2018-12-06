package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.TypevalueDao;
import com.spring.jersy.hibernate.model.entity.TypeValue;
import com.spring.jersy.hibernate.model.service.TypevalueService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TypevalueServiceImpl implements TypevalueService {

    @Autowired
    private TypevalueDao typevalueDao;


    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        return null;
    }

    @Override
    public TypeValue findByid(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(TypeValue typevalue) {

    }

    @Override
    public void saveOrUpd(TypeValue typevalue) {

    }

    @Override
    public List<TypeValue> findListByKey(String code) {
        DetachedCriteria dc = DetachedCriteria.forClass(TypeValue.class);
        if (!S.isNull(code)) {
            dc.add(Restrictions.sqlRestriction("code like '" + code + "___'"));
        }
        dc.addOrder(Order.asc("code"));
        return typevalueDao.findByDetachedCriteria(dc);
    }
}
