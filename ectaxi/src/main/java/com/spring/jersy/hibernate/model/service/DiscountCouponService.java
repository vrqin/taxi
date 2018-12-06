package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DiscountCoupon;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by x1c on 2017/7/14.
 */
public interface DiscountCouponService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DiscountCoupon findByid(Integer id);


    public DiscountCoupon findByid(Double id);


    public void delete(Integer id);

    public void save(DiscountCoupon discountCoupon);

    public void saveOrUpd(DiscountCoupon discountCoupon);

    public List<DiscountCoupon> findListByclientid(Integer clientid);
}
