package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.PunishmentLogDao;
import com.spring.jersy.hibernate.model.entity.PunishmentLog;
import com.spring.jersy.hibernate.model.service.PunishmentLogService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PunishmentLogServiceImpl implements PunishmentLogService {

    @Autowired
    private PunishmentLogDao punishmentLogDao;

    @Override
    public List<PunishmentLog> findList(PunishmentLog punishmentLog) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PunishmentLog.class);
        dc.add(Restrictions.eq("msid", punishmentLog.getMsid()));
        return punishmentLogDao.findByDetachedCriteria(dc);
    }

    @Override
    public List<PunishmentLog> findList(String kabnum) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(PunishmentLog.class);
        dc.add(Restrictions.eq("kabnum", kabnum));
        return punishmentLogDao.findByDetachedCriteria(dc);
    }
}
