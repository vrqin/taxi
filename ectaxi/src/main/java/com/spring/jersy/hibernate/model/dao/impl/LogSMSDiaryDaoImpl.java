package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.LogSMSDiaryDao;
import com.spring.jersy.hibernate.model.entity.LogSMSDiary;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/12.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class LogSMSDiaryDaoImpl extends BaseDaoImpl<LogSMSDiary, Integer> implements LogSMSDiaryDao {
    public LogSMSDiaryDaoImpl() {
        super(LogSMSDiary.class);
    }

    public LogSMSDiaryDaoImpl(Class<LogSMSDiary> entity) {
        super(entity);
    }
}
