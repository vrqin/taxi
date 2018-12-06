package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.OperatingSituationDao;
import com.spring.jersy.hibernate.model.entity.OperatingSituation;
import com.spring.jersy.hibernate.model.service.OperatingSituationService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OperatingSituationServiceImpl implements OperatingSituationService {

    @Autowired
    private OperatingSituationDao operatingSituationDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(OperatingSituation.class);

        if (!S.isNull(key)) {
            clientid = Integer.valueOf(key);
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
        pageList = operatingSituationDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public OperatingSituation findByid(Integer id) {
        return operatingSituationDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        operatingSituationDao.delete(id);
    }

    @Override
    public void save(OperatingSituation operatingSituation) {
        operatingSituationDao.save(operatingSituation);
    }

    @Override
    public void saveOrUpd(OperatingSituation operatingSituation) {
        operatingSituationDao.saveOrUpdate(operatingSituation);
    }
}
