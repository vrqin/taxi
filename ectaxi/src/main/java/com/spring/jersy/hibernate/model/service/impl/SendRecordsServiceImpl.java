package com.spring.jersy.hibernate.model.service.impl;


import com.spring.jersy.hibernate.model.dao.SendRecordsDao;
import com.spring.jersy.hibernate.model.entity.SendRecords;
import com.spring.jersy.hibernate.model.service.SendRecordsService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
@Service
public class SendRecordsServiceImpl implements SendRecordsService {

    @Autowired
    private SendRecordsDao sendRecordsDao;

    @Override
    public List<SendRecords> findAllList() {
        DetachedCriteria dc = DetachedCriteria.forClass(SendRecords.class);
        return sendRecordsDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<SendRecords> findListByorderid(String ordernum) {
        DetachedCriteria dc = DetachedCriteria.forClass(SendRecords.class);
        dc.add(Restrictions.eq("ordernum", ordernum));
        return sendRecordsDao.findByDetachedCriteria(dc);
    }

    @Override
    public SendRecords findByid(Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void save(SendRecords sendRecords) {

    }

    @Override
    public void saveOrUpd(SendRecords sendRecords) {

    }

    @Override
    public List<SendRecords> findList(String sort, String order, String key, String begintime, String endtime) throws Exception {
        return null;
    }
}
