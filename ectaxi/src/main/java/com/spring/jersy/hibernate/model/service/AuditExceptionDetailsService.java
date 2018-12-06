package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AuditExceptionDetails;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AuditExceptionDetailsService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AuditExceptionDetails findByid(Integer id);

    public void delete(Integer id);

    public void save(AuditExceptionDetails auditExceptionDetails);

    public void saveOrUpd(AuditExceptionDetails auditExceptionDetails);

}
