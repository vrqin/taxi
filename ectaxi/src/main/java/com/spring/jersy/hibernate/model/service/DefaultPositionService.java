package com.spring.jersy.hibernate.model.service;


import com.spring.jersy.hibernate.model.entity.DefaultPosition;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
public interface DefaultPositionService {

    public DefaultPosition findByid(Integer id);

    public DefaultPosition findByUseid(Integer userid, Integer id);

    public DefaultPosition findDePos();

    public void save(DefaultPosition defaultPosition);


    public List<DefaultPosition> findList(String sort, String order, String key, String begintime, String endtime) throws Exception;

    public void delete(Integer id);

    public void saveOrUpd(DefaultPosition corporateIncomeRanking);


}
