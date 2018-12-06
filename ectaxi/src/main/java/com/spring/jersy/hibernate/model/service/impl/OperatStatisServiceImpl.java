package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperatStatisDao;
import com.spring.jersy.hibernate.model.entity.OperatStatis;
import com.spring.jersy.hibernate.model.service.OperatStatisService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperatStatisServiceImpl implements OperatStatisService {

    @Autowired
    private OperatStatisDao operatStatisDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperatStatis.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(kabnum like '%" + key + "%' or name like '%" + key + "%'or enterprise like '%" + key + "%')"));
        }
        if (clientid > 0) {
            dc.add(Restrictions.eq("enterprise", clientid));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = operatStatisDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperatStatis findByid(Integer id) {
        return operatStatisDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operatStatisDao.delete(id);
    }

    @Override
    public void save(OperatStatis operatStatis) {
        operatStatisDao.save(operatStatis);
    }

    @Override
    public void saveOrUpd(OperatStatis operatStatis) {
        operatStatisDao.saveOrUpdate(operatStatis);
    }
}
