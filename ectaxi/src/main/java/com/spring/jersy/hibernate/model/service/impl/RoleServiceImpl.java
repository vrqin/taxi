package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.RoleDao;
import com.spring.jersy.hibernate.model.entity.Role;
import com.spring.jersy.hibernate.model.service.RoleService;
import com.spring.jersy.hibernate.publics.bean.RoleidToResourseid;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    public static StringBuffer RoleList(String key, Integer clientid) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" select roleId,`name`,roleName,roleRemark,registerTime from tab_role   ");
        sqllsit.append("  WHERE (clientid =0 OR clientid ='%" + clientid + "%'  ) ");
        if (!S.isNull(key)) {
            sqllsit.append("  and `name` LIKE '%" + key + "%'   ");
        }
        return sqllsit;


    }

    public static StringBuffer RoleidReoursid(Integer key) {
        StringBuffer sqllsit = new StringBuffer();
        sqllsit.append(" SELECT role_id,resource_id FROM `tab_role_resource`WHERE role_id =" + key);
        return sqllsit;


    }

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Role.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or company like '%" + key + "%'or remark like '%" + key + "%')"));
        }

        if (type > (-1)) {
            dc.add(Restrictions.eq("validity", type));
        }

        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = roleDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Role findByid(Integer id) {
        return roleDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        roleDao.delete(id);
    }

    @Override
    public void delRoleidReoursid(Integer id) {
        String sql = " DELETE FROM `tab_role_resource` WHERE role_id = " + id;
        roleDao.updateSql(sql);
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public void saveOrUpd(Role role) {
        roleDao.saveOrUpdate(role);
    }

    @Override
    public List<Role> findRoleList(String key, Integer clientid) throws Exception {
        StringBuffer sqllsit = RoleList(key, clientid);
        List<Object[]> list = roleDao.findListSql(String.valueOf(sqllsit));
        List<Role> callBusslist = new ArrayList<Role>();
        Role callBean;
        for (Object[] objects : list) {
            callBean = new Role();
            callBean.setRoleId(objects[0] == null ? 0 : Integer.valueOf(objects[0].toString()));
            callBean.setName(objects[1] == null ? "" : objects[1].toString());
            callBean.setRoleName(objects[2] == null ? "" : objects[2].toString());
            callBean.setRoleRemark(objects[3] == null ? "" : objects[3].toString());
            callBean.setRegisterTime(objects[4] == null ? null : DateUtil.stringToDate(objects[4].toString(), "yyyy-MM-dd HH:mm:ss"));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<RoleidToResourseid> findRoleidToResourseidList(Integer key) throws Exception {
        StringBuffer sqllsit = RoleidReoursid(key);
        List<Object[]> list = roleDao.findListSql(String.valueOf(sqllsit));
        List<RoleidToResourseid> callBusslist = new ArrayList<RoleidToResourseid>();
        RoleidToResourseid callBean;
        for (Object[] objects : list) {
            callBean = new RoleidToResourseid();
            callBean.setRoleid(objects[0] == null ? 0 : Integer.valueOf(objects[0].toString()));
            callBean.setResourseid(objects[1] == null ? 0 : Integer.valueOf(objects[1].toString()));
            callBusslist.add(callBean);
        }
        return callBusslist;
    }

    @Override
    public List<Role> findRoleListtree() throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Role.class);
        dc.add(Restrictions.ne("roleId", 1));
        dc.addOrder(Order.asc("roleId"));
        return roleDao.findByDetachedCriteria(dc);
    }

}
