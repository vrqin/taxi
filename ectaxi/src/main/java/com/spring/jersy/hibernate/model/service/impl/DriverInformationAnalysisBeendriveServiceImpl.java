package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.DriverInformationAnalysisBeendriveDao;
import com.spring.jersy.hibernate.model.entity.DriverInformationAnalysisBeendrive;
import com.spring.jersy.hibernate.model.service.DriverInformationAnalysisBeendriveService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DriverInformationAnalysisBeendriveServiceImpl implements DriverInformationAnalysisBeendriveService {

    @Autowired
    private DriverInformationAnalysisBeendriveDao driverInformationAnalysisBeendriveDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(DriverInformationAnalysisBeendrive.class);

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
        pageList = driverInformationAnalysisBeendriveDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public DriverInformationAnalysisBeendrive findByid(Integer id) {
        return driverInformationAnalysisBeendriveDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        driverInformationAnalysisBeendriveDao.delete(id);
    }

    @Override
    public void save(DriverInformationAnalysisBeendrive driverInformationAnalysisBeendrive) {
        driverInformationAnalysisBeendriveDao.save(driverInformationAnalysisBeendrive);
    }

    @Override
    public void saveOrUpd(DriverInformationAnalysisBeendrive driverInformationAnalysisBeendrive) {
        driverInformationAnalysisBeendriveDao.saveOrUpdate(driverInformationAnalysisBeendrive);
    }
}
