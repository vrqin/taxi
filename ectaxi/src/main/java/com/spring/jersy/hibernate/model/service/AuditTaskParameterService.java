package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AuditTaskParameter;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AuditTaskParameterService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AuditTaskParameter findByid(Integer id);

    public void delete(Integer id);

    public void save(AuditTaskParameter auditTaskParameter);

    public void saveOrUpd(AuditTaskParameter auditTaskParameter);

}
