package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarInformationAnalysisRegionDao;
import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisRegion;
import com.spring.jersy.hibernate.model.service.CarInformationAnalysisRegionService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarInformationAnalysisRegionServiceImpl implements CarInformationAnalysisRegionService {

    @Autowired
    private CarInformationAnalysisRegionDao carInformationAnalysisRegionDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarInformationAnalysisRegion.class);

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
        pageList = carInformationAnalysisRegionDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarInformationAnalysisRegion findByid(Integer id) {
        return carInformationAnalysisRegionDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carInformationAnalysisRegionDao.delete(id);
    }

    @Override
    public void save(CarInformationAnalysisRegion carInformationAnalysisRegion) {
        carInformationAnalysisRegionDao.save(carInformationAnalysisRegion);
    }

    @Override
    public void saveOrUpd(CarInformationAnalysisRegion carInformationAnalysisRegion) {
        carInformationAnalysisRegionDao.saveOrUpdate(carInformationAnalysisRegion);
    }
}
