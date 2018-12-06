package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PunishmentLogDao;
import com.spring.jersy.hibernate.model.entity.PunishmentLog;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PunishmentLogDaoImpl extends BaseDaoImpl<PunishmentLog, Integer> implements PunishmentLogDao {
    public PunishmentLogDaoImpl() {
        super(PunishmentLog.class);
    }

    public PunishmentLogDaoImpl(Class<PunishmentLog> entity) {
        super(entity);
    }
}
