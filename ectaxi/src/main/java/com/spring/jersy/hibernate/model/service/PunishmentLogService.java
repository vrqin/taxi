package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.PunishmentLog;

import java.util.List;

public interface PunishmentLogService {

    public List<PunishmentLog> findList(PunishmentLog punishmentLog) throws Exception;

    List<PunishmentLog> findList(String kabnum) throws Exception;
}
