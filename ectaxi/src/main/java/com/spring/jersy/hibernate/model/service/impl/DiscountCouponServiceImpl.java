package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DiscountCouponDao;
import com.spring.jersy.hibernate.model.entity.DiscountCoupon;
import com.spring.jersy.hibernate.model.service.DiscountCouponService;
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
public class DiscountCouponServiceImpl implements DiscountCouponService {
    @Autowired
    private DiscountCouponDao discountCouponDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DiscountCoupon.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' )"));
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
        pageList = discountCouponDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DiscountCoupon findByid(Integer id) {
        return discountCouponDao.get(id);
    }

    @Override
    public DiscountCoupon findByid(Double id) {
        DetachedCriteria dc = DetachedCriteria.forClass(DiscountCoupon.class);
        dc.add(Restrictions.eq("id", id));
        return discountCouponDao.findByDetachedCriteriaObj(dc);
    }


    @Override
    public void delete(Integer id) {
        discountCouponDao.delete(id);
    }

    @Override
    public void save(DiscountCoupon discountCoupon) {

        discountCouponDao.save(discountCoupon);
    }

    @Override
    public void saveOrUpd(DiscountCoupon discountCoupon) {


        discountCouponDao.saveOrUpdate(discountCoupon);
    }

    @Override
    public List<DiscountCoupon> findListByclientid(Integer clientid) {
        DetachedCriteria dc = DetachedCriteria.forClass(DiscountCoupon.class);
        if (!S.isNull(clientid)) {
            dc.add(Restrictions.eq("clientId", clientid));
        }

        return discountCouponDao.findByDetachedCriteria(dc);
    }
}
