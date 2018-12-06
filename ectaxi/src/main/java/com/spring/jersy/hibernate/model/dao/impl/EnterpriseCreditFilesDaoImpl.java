package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.EnterpriseCreditFilesDao;
import com.spring.jersy.hibernate.model.entity.EnterpriseCreditFiles;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class EnterpriseCreditFilesDaoImpl extends BaseDaoImpl<EnterpriseCreditFiles, Integer> implements EnterpriseCreditFilesDao {
    public EnterpriseCreditFilesDaoImpl() {
        super(EnterpriseCreditFiles.class);
    }

    public EnterpriseCreditFilesDaoImpl(Class<EnterpriseCreditFiles> entity) {
        super(entity);
    }
}
