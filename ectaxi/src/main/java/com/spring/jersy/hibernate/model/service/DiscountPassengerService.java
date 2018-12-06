package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.DiscountPassenger;
import com.spring.jersy.hibernate.publics.util.PageList;

import java.util.List;

/**
 * Created by x1c on 2017/7/14.
 */
public interface DiscountPassengerService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public DiscountPassenger findByid(Integer id);

    public void delete(Integer id);

    public void save(DiscountPassenger discountPassenger);

    public void saveOrUpd(DiscountPassenger discountPassenger);

    public List<DiscountPassenger> findListByclientid(Integer clientid);
}
