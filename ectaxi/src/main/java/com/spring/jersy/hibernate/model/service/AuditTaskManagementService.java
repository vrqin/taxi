package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.AuditTaskManagement;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface AuditTaskManagementService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public AuditTaskManagement findByid(Integer id);

    public void delete(Integer id);

    public void save(AuditTaskManagement auditTaskManagement);

    public void saveOrUpd(AuditTaskManagement auditTaskManagement);

}
