package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverInformationAnalysisCreditrateDao;
import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisCreditrate;
import com.spring.jersy.hibernate.model.service.DriverInformationAnalysisCreditrateService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverInformationAnalysisCreditrateServiceImpl implements DriverInformationAnalysisCreditrateService {

    @Autowired
    private DriverInformationAnalysisCreditrateDao driverInformationAnalysisCreditrateDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverInformationAnalysisCreditrate.class);

        if (!S.isNull(begintime)) {

            dc.add(Restrictions.ge("annual", begintime));
        }

        if (!S.isNull(endtime)) {

            dc.add(Restrictions.le("annual", endtime));
        }
        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = driverInformationAnalysisCreditrateDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverInformationAnalysisCreditrate findByid(Integer id) {
        return driverInformationAnalysisCreditrateDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverInformationAnalysisCreditrateDao.delete(id);
    }

    @Override
    public void save(DriverInformationAnalysisCreditrate driverInformationAnalysisCreditrate) {
        driverInformationAnalysisCreditrateDao.save(driverInformationAnalysisCreditrate);
    }

    @Override
    public void saveOrUpd(DriverInformationAnalysisCreditrate driverInformationAnalysisCreditrate) {
        driverInformationAnalysisCreditrateDao.saveOrUpdate(driverInformationAnalysisCreditrate);
    }
}
