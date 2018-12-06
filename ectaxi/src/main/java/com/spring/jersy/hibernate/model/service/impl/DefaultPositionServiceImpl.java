package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.DefaultPositionDao;
import com.spring.jersy.hibernate.model.entity.DefaultPosition;
import com.spring.jersy.hibernate.model.service.DefaultPositionService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/6.
 */
@Service
public class DefaultPositionServiceImpl implements DefaultPositionService {
    @Autowired
    private DefaultPositionDao defaultPositionDao;

    @Override
    public DefaultPosition findByid(Integer id) {
        return defaultPositionDao.get(id);
    }

    @Override
    public DefaultPosition findByUseid(Integer userid, Integer id) {
        DetachedCriteria dc = DetachedCriteria.forClass(DefaultPosition.class);
        dc.add(Restrictions.eq("ssid", id));
        dc.add(Restrictions.eq("userId", userid));
        return defaultPositionDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public DefaultPosition findDePos() {
        DetachedCriteria dc = DetachedCriteria.forClass(DefaultPosition.class);
        return defaultPositionDao.findByDetachedCriteriaObj(dc);
    }

    @Override
    public void save(DefaultPosition defaultPosition) {
        defaultPositionDao.save(defaultPosition);
    }

    @Override
    public List<DefaultPosition> findList(String sort, String order, String key, String begintime, String endtime) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void saveOrUpd(DefaultPosition corporateIncomeRanking) {
        defaultPositionDao.saveOrUpdate(corporateIncomeRanking);
    }


}
