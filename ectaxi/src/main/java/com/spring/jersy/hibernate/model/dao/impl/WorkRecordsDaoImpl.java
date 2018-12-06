package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.WorkRecordsDao;
import com.spring.jersy.hibernate.model.entity.WorkRecords;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/8/15.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class WorkRecordsDaoImpl extends BaseDaoImpl<WorkRecords, Integer> implements WorkRecordsDao {
    public WorkRecordsDaoImpl() {
        super(WorkRecords.class);
    }

    public WorkRecordsDaoImpl(Class<WorkRecords> entity) {
        super(entity);
    }
}
