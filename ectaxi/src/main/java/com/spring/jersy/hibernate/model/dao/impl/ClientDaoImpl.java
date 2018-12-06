package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.ClientDao;
import com.spring.jersy.hibernate.model.entity.Client;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class ClientDaoImpl extends BaseDaoImpl<Client, Integer> implements ClientDao {
    public ClientDaoImpl() {
        super(Client.class);
    }

    public ClientDaoImpl(Class<Client> entity) {
        super(entity);
    }
}
