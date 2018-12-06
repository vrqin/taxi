package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DiscountPassengerDao;
import com.spring.jersy.hibernate.model.entity.DiscountPassenger;
import com.spring.jersy.hibernate.model.service.DiscountPassengerService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by x1c on 2017/7/14.
 */
@Service
public class DiscountPassengerServiceimpl implements DiscountPassengerService {
    @Autowired
    private DiscountPassengerDao discountPassengerDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DiscountPassenger.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(discid like '%" + key + "%' )"));
        }
        //        if(!S.isNull(begintime)){
        //            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
        //            dc.add(Restrictions.ge("calltime",start));
        //        }
        //
        //        if(!S.isNull(endtime)){
        //            Date end = DateUtil.stringToDate(endtime,"yyyy-MM-dd HH:mm:ss");
        //            dc.add(Restrictions.le("calltime", end));
        //        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }

        PageList pageList = new PageList(page, rows);
        pageList = discountPassengerDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DiscountPassenger findByid(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(DiscountPassenger discountPassenger) {

    }

    @Override
    public void saveOrUpd(DiscountPassenger discountPassenger) {

    }

    @Override
    public List<DiscountPassenger> findListByclientid(Integer clientid) {
        return null;
    }
}
