package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.LogOperationDao;
import com.spring.jersy.hibernate.model.entity.LogOperation;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/12.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class LogOperationDaoImpl extends BaseDaoImpl<LogOperation, Integer> implements LogOperationDao {
    public LogOperationDaoImpl() {
        super(LogOperation.class);
    }

    public LogOperationDaoImpl(Class<LogOperation> entity) {
        super(entity);
    }
}
