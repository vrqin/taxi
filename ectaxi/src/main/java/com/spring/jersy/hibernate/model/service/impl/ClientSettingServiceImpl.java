package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.ClientSettingDao;
import com.spring.jersy.hibernate.model.entity.ClientSetting;
import com.spring.jersy.hibernate.model.service.ClientSettingService;
import com.spring.jersy.hibernate.publics.util.PageList;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClientSettingServiceImpl implements ClientSettingService {

    @Autowired
    private ClientSettingDao clientSettingDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(ClientSetting.class);

        //        if (!S.isNull(key)){
        //            dc.add(Restrictions.sqlRestriction("(name like '%"+key+"%' or phone like '%"+key+"%'or kabnum like '%"+key+"%')"));
        //        }
        //        if(!S.isNull(begintime)){
        //            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
        //            dc.add(Restrictions.ge("calltime",start));
        //        }
        //
        //        if(!S.isNull(endtime)){
        //            Date end = DateUtil.stringToDate(endtime,"yyyy-MM-dd HH:mm:ss");
        //            dc.add(Restrictions.le("calltime", end));
        //        }
        //
        //        if (!S.isNull(type)){
        //            dc.add(Restrictions.eq("type",type));
        //        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = clientSettingDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public ClientSetting findByid(Integer id) {
        return clientSettingDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        clientSettingDao.delete(id);
    }

    @Override
    public void save(ClientSetting clientSetting) {
        clientSettingDao.save(clientSetting);
    }

    @Override
    public void saveOrUpd(ClientSetting clientSetting) {
        clientSettingDao.saveOrUpdate(clientSetting);
    }

    @Override
    public List<ClientSetting> findListByid(Integer id) {
        DetachedCriteria dc = DetachedCriteria.forClass(ClientSetting.class);
        if (id > 0) {
            dc.add(Restrictions.eq("clientid", id));
        }
        dc.add(Restrictions.eq("messagenum", 0));
        return clientSettingDao.findByDetachedCriteria(dc);
    }
}
