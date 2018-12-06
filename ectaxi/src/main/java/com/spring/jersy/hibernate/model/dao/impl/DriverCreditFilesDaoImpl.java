package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.DriverCreditFilesDao;
import com.spring.jersy.hibernate.model.entity.DriverCreditFiles;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class DriverCreditFilesDaoImpl extends BaseDaoImpl<DriverCreditFiles, Integer> implements DriverCreditFilesDao {
    public DriverCreditFilesDaoImpl() {
        super(DriverCreditFiles.class);
    }

    public DriverCreditFilesDaoImpl(Class<DriverCreditFiles> entity) {
        super(entity);
    }
}
