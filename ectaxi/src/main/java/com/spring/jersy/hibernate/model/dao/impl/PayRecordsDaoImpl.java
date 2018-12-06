package com.spring.jersy.hibernate.model.dao.impl;


import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.PayRecordsDao;
import com.spring.jersy.hibernate.model.entity.PayRecords;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/8/15.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class PayRecordsDaoImpl extends BaseDaoImpl<PayRecords, Integer> implements PayRecordsDao {
    public PayRecordsDaoImpl() {
        super(PayRecords.class);
    }

    public PayRecordsDaoImpl(Class<PayRecords> entity) {
        super(entity);
    }
}
