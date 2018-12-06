package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarIntegratedQueryDao;
import com.spring.jersy.hibernate.model.entity.CarIntegratedQuery;
import com.spring.jersy.hibernate.model.service.CarIntegratedQueryService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarIntegratedQueryServiceImpl implements CarIntegratedQueryService {

    @Autowired
    private CarIntegratedQueryDao carIntegratedQueryDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarIntegratedQuery.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or unit like '%" + key + "%'or totalincome like '%" + key + "%')"));
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
        pageList = carIntegratedQueryDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarIntegratedQuery findByid(Integer id) {
        return carIntegratedQueryDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carIntegratedQueryDao.delete(id);
    }

    @Override
    public void save(CarIntegratedQuery carIntegratedQuery) {
        carIntegratedQueryDao.save(carIntegratedQuery);
    }

    @Override
    public void saveOrUpd(CarIntegratedQuery carIntegratedQuery) {
        carIntegratedQueryDao.saveOrUpdate(carIntegratedQuery);
    }
}