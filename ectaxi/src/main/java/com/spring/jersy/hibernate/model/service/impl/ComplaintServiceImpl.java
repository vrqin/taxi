package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.ComplaintDao;
import com.spring.jersy.hibernate.model.entity.Complaint;
import com.spring.jersy.hibernate.model.service.ComplaintService;
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
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Byte source, Byte results, Byte state, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Complaint.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or customername like '%" + key + "%'or phone like '%" + key + "%'or kabnum like '%" + key + "%'or ordernum like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("acceptime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("acceptime", end));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }
        if (source > (-1)) {
            dc.add(Restrictions.eq("source", source));
        }
        if (results > (-1)) {
            dc.add(Restrictions.eq("results", results));
        }
        if (state > (-1)) {
            dc.add(Restrictions.eq("state", state));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = complaintDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Complaint findByid(Integer id) {
        return complaintDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        complaintDao.delete(id);
    }

    @Override
    public void save(Complaint complaint) {
        complaintDao.save(complaint);
    }

    @Override
    public void saveOrUpd(Complaint complaint) {
        complaintDao.saveOrUpdate(complaint);
    }
}
