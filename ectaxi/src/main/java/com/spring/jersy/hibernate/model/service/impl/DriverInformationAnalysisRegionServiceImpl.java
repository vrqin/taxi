package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverInformationAnalysisRegionDao;
import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisRegion;
import com.spring.jersy.hibernate.model.service.DriverInformationAnalysisRegionService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverInformationAnalysisRegionServiceImpl implements DriverInformationAnalysisRegionService {

    @Autowired
    private DriverInformationAnalysisRegionDao driverInformationAnalysisRegionDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverInformationAnalysisRegion.class);

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
        pageList = driverInformationAnalysisRegionDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverInformationAnalysisRegion findByid(Integer id) {
        return driverInformationAnalysisRegionDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverInformationAnalysisRegionDao.delete(id);
    }

    @Override
    public void save(DriverInformationAnalysisRegion driverInformationAnalysisRegion) {
        driverInformationAnalysisRegionDao.save(driverInformationAnalysisRegion);
    }

    @Override
    public void saveOrUpd(DriverInformationAnalysisRegion driverInformationAnalysisRegion) {
        driverInformationAnalysisRegionDao.saveOrUpdate(driverInformationAnalysisRegion);
    }
}
