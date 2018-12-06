package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.CarInformationAnalysisValidittimeDao;
import com.spring.jersy.hibernate.model.entity.CarInformationAnalysisValidittime;
import com.spring.jersy.hibernate.model.service.CarInformationAnalysisValidittimeService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarInformationAnalysisValidittimeServiceImpl implements CarInformationAnalysisValidittimeService {

    @Autowired
    private CarInformationAnalysisValidittimeDao carInformationAnalysisValidittimeDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(CarInformationAnalysisValidittime.class);

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
        pageList = carInformationAnalysisValidittimeDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public CarInformationAnalysisValidittime findByid(Integer id) {
        return carInformationAnalysisValidittimeDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        carInformationAnalysisValidittimeDao.delete(id);
    }

    @Override
    public void save(CarInformationAnalysisValidittime carInformationAnalysisValidittime) {
        carInformationAnalysisValidittimeDao.save(carInformationAnalysisValidittime);
    }

    @Override
    public void saveOrUpd(CarInformationAnalysisValidittime carInformationAnalysisValidittime) {
        carInformationAnalysisValidittimeDao.saveOrUpdate(carInformationAnalysisValidittime);
    }
}
