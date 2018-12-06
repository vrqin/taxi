package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarInformationAnalysisModelsDao;
import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisModels;
import com.spring.jersy.hibernate.model.service.CarInformationAnalysisModelsService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarInformationAnalysisModelsServiceImpl implements CarInformationAnalysisModelsService {

    @Autowired
    private CarInformationAnalysisModelsDao carInformationAnalysisModelsDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarInformationAnalysisModels.class);

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
        pageList = carInformationAnalysisModelsDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarInformationAnalysisModels findByid(Integer id) {
        return carInformationAnalysisModelsDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carInformationAnalysisModelsDao.delete(id);
    }

    @Override
    public void save(CarInformationAnalysisModels carInformationAnalysisModels) {
        carInformationAnalysisModelsDao.save(carInformationAnalysisModels);
    }

    @Override
    public void saveOrUpd(CarInformationAnalysisModels carInformationAnalysisModels) {
        carInformationAnalysisModelsDao.saveOrUpdate(carInformationAnalysisModels);
    }
}
