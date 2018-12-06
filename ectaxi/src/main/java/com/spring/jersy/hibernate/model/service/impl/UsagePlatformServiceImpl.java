package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.UsagePlatformDao;
import com.spring.jersy.hibernate.model.entity.UsagePlatform;
import com.spring.jersy.hibernate.model.service.UsagePlatformService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsagePlatformServiceImpl implements UsagePlatformService {

    @Autowired
    private UsagePlatformDao usagePlatformDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type, int clientid) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(UsagePlatform.class);

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
        pageList = usagePlatformDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public UsagePlatform findByid(Integer id) {
        return usagePlatformDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        usagePlatformDao.delete(id);
    }

    @Override
    public void save(UsagePlatform usagePlatform) {
        usagePlatformDao.save(usagePlatform);
    }

    @Override
    public void saveOrUpd(UsagePlatform usagePlatform) {
        usagePlatformDao.saveOrUpdate(usagePlatform);
    }
}
