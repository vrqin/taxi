package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.LogLoginDao;
import com.spring.jersy.hibernate.model.entity.LogLogin;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/12.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class LogLoginDaoImpl extends BaseDaoImpl<LogLogin, Integer> implements LogLoginDao {
    public LogLoginDaoImpl() {
        super(LogLogin.class);
    }

    public LogLoginDaoImpl(Class<LogLogin> entity) {
        super(entity);
    }
}
