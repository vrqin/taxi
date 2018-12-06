package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.LostAcceptDao;
import com.spring.jersy.hibernate.model.entity.LostAccept;
import com.spring.jersy.hibernate.model.service.LostAcceptService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/9.
 */
@Service
public class LostAcceptServiceImpl implements LostAcceptService {

    @Autowired
    private LostAcceptDao lostAcceptDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, String getonstartime, String getonendtime, Byte classify, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LostAccept.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or phone like '%" + key + "%'or kabnum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("calltime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("calltime", end));
        }

        if (!S.isNull(getonstartime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("geton", start));
        }

        if (!S.isNull(getonendtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("geton", end));
        }

        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if (classify > (-1)) {
            dc.add(Restrictions.eq("classify", classify));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = lostAcceptDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public LostAccept findByid(Integer id) {
        return lostAcceptDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        lostAcceptDao.delete(id);
    }

    @Override
    public void save(LostAccept lostAccept) {
        lostAcceptDao.save(lostAccept);
    }

    @Override
    public void saveOrUpd(LostAccept lostAccept) {
        lostAcceptDao.saveOrUpdate(lostAccept);
    }
}
