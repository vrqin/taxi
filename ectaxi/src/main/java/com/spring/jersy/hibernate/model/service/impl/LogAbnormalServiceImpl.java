package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.LogAbnormalDao;
import com.spring.jersy.hibernate.model.entity.LogAbnormal;
import com.spring.jersy.hibernate.model.service.LogAbnormalService;
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
public class LogAbnormalServiceImpl implements LogAbnormalService {

    @Autowired
    private LogAbnormalDao logAbnormalDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, Integer clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(LogAbnormal.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(operation like '%" + key + "%' or operator like '%" + key + "%')"));
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
        pageList = logAbnormalDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public LogAbnormal findByid(Integer id) {
        return logAbnormalDao.get(id);
    }

    @Override
    public void save(LogAbnormal logAbnormal) {
        logAbnormalDao.save(logAbnormal);
    }

    @Override
    public void saveOrUpd(LogAbnormal logAbnormal) {
        logAbnormalDao.saveOrUpdate(logAbnormal);
    }

    @Override
    public void savelogAbnormal(String token, String content, Integer clientid) {
        try {

            LogAbnormal logAbnormal = new LogAbnormal();
            logAbnormal.setOperator(token);
            if (content.length() > 255) {
                content = content.substring(0, 255);
            }
            logAbnormal.setReturninfo(content);
            logAbnormal.setOperattime(new Date());
            logAbnormal.setClientid(clientid);

            logAbnormalDao.save(logAbnormal);
        } catch (Exception e) {
            //System.out.println("添加错误日志："+e);
        }
    }
}
