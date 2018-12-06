package com.spring.jersy.hibernate.model.dao.impl;

import com.spring.jersy.hibernate.model.base.dao.impl.BaseDaoImpl;
import com.spring.jersy.hibernate.model.dao.InvoiceDao;
import com.spring.jersy.hibernate.model.entity.Invoice;
import com.spring.jersy.hibernate.publics.util.SpringAnnotationDef;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Scope(SpringAnnotationDef.SCOPE_PROTOTYPE)
@Repository
public class InvoiceDaoImpl extends BaseDaoImpl<Invoice, Integer> implements InvoiceDao {
    public InvoiceDaoImpl() {
        super(Invoice.class);
    }

    public InvoiceDaoImpl(Class<Invoice> entity) {
        super(entity);
    }
}
