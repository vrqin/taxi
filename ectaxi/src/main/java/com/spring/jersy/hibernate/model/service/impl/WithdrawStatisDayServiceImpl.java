package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.WithdrawStatisDayDao;
import com.spring.jersy.hibernate.model.entity.WithdrawStatisDay;
import com.spring.jersy.hibernate.model.service.WithdrawStatisDayService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WithdrawStatisDayServiceImpl implements WithdrawStatisDayService {

    @Autowired
    private WithdrawStatisDayDao withdrawStatisDayDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(WithdrawStatisDay.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(  company like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("date", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("date", endtime));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = withdrawStatisDayDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public WithdrawStatisDay findByid(Integer id) {
        return withdrawStatisDayDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        withdrawStatisDayDao.delete(id);
    }

    @Override
    public void save(WithdrawStatisDay withdrawStatisDay) {
        withdrawStatisDayDao.save(withdrawStatisDay);
    }

    @Override
    public void saveOrUpd(WithdrawStatisDay withdrawStatisDay) {
        withdrawStatisDayDao.saveOrUpdate(withdrawStatisDay);
    }
}
