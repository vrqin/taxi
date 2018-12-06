package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.AssessManageDao;
import com.spring.jersy.hibernate.model.entity.AssessManage;
import com.spring.jersy.hibernate.model.service.AssessManageService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AssessManageServiceImpl implements AssessManageService {
    @Autowired
    private AssessManageDao assessManageDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(AssessManage.class);
        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(evaluationlevel like '%" + key + "%' or levelexplanation like '%" + key + "%'or fractionone like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("createtime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("createtime", end));
        }

        if (!S.isNull(type)) {
            dc.add(Restrictions.eq("versiontype", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = assessManageDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public AssessManage findByid(Integer id) {
        return assessManageDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        assessManageDao.delete(id);
    }

    @Override
    public void save(AssessManage assessManage) {
        assessManageDao.save(assessManage);
    }

    @Override
    public void saveOrUpd(AssessManage assessManage) {
        assessManageDao.saveOrUpdate(assessManage);
    }
}
