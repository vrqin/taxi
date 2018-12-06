package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.LogOperationDao;
import com.spring.jersy.hibernate.model.entity.LogOperation;
import com.spring.jersy.hibernate.model.service.LogOperationService;
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
 * Created by Administrator on 2016/9/12.
 */
@Service
public class LogOperationServiceImpl implements LogOperationService {

    @Autowired
    private LogOperationDao logOperationDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LogOperation.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(operation like '%" + key + "%' or operatobject like '%" + key + "%'or operator like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("operattime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("operattime", end));
        }

        if (clientid > 0) {
            dc.add(Restrictions.eq("clientid", clientid));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = logOperationDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public LogOperation findByid(Integer id) {
        return logOperationDao.get(id);
    }

    @Override
    public void save(LogOperation logOperation) {
        logOperationDao.save(logOperation);
    }

    @Override
    public void saveOrUpd(LogOperation logOperation) {
        logOperationDao.saveOrUpdate(logOperation);
    }

    @Override
    public void savelogOperation(String token, int type, String content, Integer clientid) {
        try {
            LogOperation logOperation = new LogOperation();
            logOperation.setOperator(token);
            logOperation.setType(type);
            logOperation.setContent(content);
            logOperation.setOperattime(new Date());
            logOperation.setClientid(clientid);

            logOperationDao.save(logOperation);
        } catch (Exception e) {
            //System.out.println("添加操作日志："+e);
        }
    }
}
