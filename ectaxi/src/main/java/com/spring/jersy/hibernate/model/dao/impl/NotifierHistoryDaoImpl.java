package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.NotifierHistoryDao;
import com.spring.jersy.hibernate.model.entity.NotifierPlusHistory;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class NotifierHistoryDaoImpl extends BaseDaoImpl<NotifierPlusHistory, Integer> implements NotifierHistoryDao {
    public NotifierHistoryDaoImpl() {
        super(NotifierPlusHistory.class);
    }

    public NotifierHistoryDaoImpl(Class<NotifierPlusHistory> entity) {
        super(entity);
    }
}
