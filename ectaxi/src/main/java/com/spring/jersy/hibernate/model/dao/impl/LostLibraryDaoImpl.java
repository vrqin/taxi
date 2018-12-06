package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.LostLibraryDao;
import com.spring.jersy.hibernate.model.entity.LostLibrary;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/9/9.
 */
@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class LostLibraryDaoImpl extends BaseDaoImpl<LostLibrary, Integer> implements LostLibraryDao {
    public LostLibraryDaoImpl() {
        super(LostLibrary.class);
    }

    public LostLibraryDaoImpl(Class<LostLibrary> entity) {
        super(entity);
    }
}
