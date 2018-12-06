package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.LogAbnormalDao;
import com.spring.jersy.hibernate.model.entity.LogAbnormal;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/12.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class LogAbnormalDaoImpl extends BaseDaoImpl<LogAbnormal, Integer> implements LogAbnormalDao {
    public LogAbnormalDaoImpl() {
        super(LogAbnormal.class);
    }

    public LogAbnormalDaoImpl(Class<LogAbnormal> entity) {
        super(entity);
    }
}
