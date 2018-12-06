package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.FatigueDrivingStatisDao;
import com.spring.jersy.hibernate.model.entity.FatigueDrivingStatis;
import com.spring.jersy.hibernate.model.service.FatigueDrivingStatisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FatigueDrivingStatisServiceImpl implements FatigueDrivingStatisService {

    @Autowired
    private FatigueDrivingStatisDao fatigueDrivingStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(FatigueDrivingStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or driver like '%" + key + "%'or unit like '%" + key + "%')"));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = fatigueDrivingStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public FatigueDrivingStatis findByid(Integer id) {
        return fatigueDrivingStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        fatigueDrivingStatisDao.delete(id);
    }

    @Override
    public void save(FatigueDrivingStatis fatigueDrivingStatis) {
        fatigueDrivingStatisDao.save(fatigueDrivingStatis);
    }

    @Override
    public void saveOrUpd(FatigueDrivingStatis fatigueDrivingStatis) {
        fatigueDrivingStatisDao.saveOrUpdate(fatigueDrivingStatis);
    }
}
