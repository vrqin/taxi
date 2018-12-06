package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.StaffDao;
import com.spring.jersy.hibernate.model.entity.Staff;
import com.spring.jersy.hibernate.model.service.StaffService;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(name like '%" + key + "%' or unit like '%" + key + "%'or employeeid like '%" + key + "%')"));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = staffDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Staff findByid(Integer id) {
        return staffDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        staffDao.delete(id);
    }

    @Override
    public void save(Staff staff) {
        staffDao.save(staff);
    }

    @Override
    public void saveOrUpd(Staff staff) {
        staffDao.saveOrUpdate(staff);
    }
}
