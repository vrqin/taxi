package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.TerminalDao;
import com.spring.jersy.hibernate.model.entity.Terminal;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class TerminalDaoImpl extends BaseDaoImpl<Terminal, Integer> implements TerminalDao {
    public TerminalDaoImpl() {
        super(Terminal.class);
    }

    public TerminalDaoImpl(Class<Terminal> entity) {
        super(entity);
    }
}
