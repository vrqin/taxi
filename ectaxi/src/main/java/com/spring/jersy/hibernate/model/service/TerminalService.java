package com.spring.jersy.hibernate.model.service;

import com.spring.jersy.hibernate.model.entity.Terminal;
import com.spring.jersy.hibernate.publics.util.PageList;

public interface TerminalService {

    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception;

    public Terminal findByid(Integer id);

    public void delete(Integer id);

    public void save(Terminal terminal);

    public void saveOrUpd(Terminal terminal);

}
