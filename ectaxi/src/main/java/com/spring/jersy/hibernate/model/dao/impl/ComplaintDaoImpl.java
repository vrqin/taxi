package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.ComplaintDao;
import com.spring.jersy.hibernate.model.entity.Complaint;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class ComplaintDaoImpl extends BaseDaoImpl<Complaint, Integer> implements ComplaintDao {
    public ComplaintDaoImpl() {
        super(Complaint.class);
    }

    public ComplaintDaoImpl(Class<Complaint> entity) {
        super(entity);
    }
}
