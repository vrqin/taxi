package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.SendRecordsDao;
import com.spring.jersy.hibernate.model.entity.SendRecords;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/8/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class SendRecordsDaoImpl extends BaseDaoImpl<SendRecords, Integer> implements SendRecordsDao {
    public SendRecordsDaoImpl() {
        super(SendRecords.class);
    }

    public SendRecordsDaoImpl(Class<SendRecords> entity) {
        super(entity);
    }
}
