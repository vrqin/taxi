package com.spring.jersy.hibernate.model.service.impl;

import com.spring.jersy.hibernate.model.dao.InvoiceDao;
import com.spring.jersy.hibernate.model.entity.Invoice;
import com.spring.jersy.hibernate.model.service.InvoiceService;
import com.spring.jersy.hibernate.publics.util.DateUtil;
import com.spring.jersy.hibernate.publics.util.PageList;
import com.spring.jersy.hibernate.publics.util.S;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceDao invoiceDao;

    @Override
    public PageList findList(int page, int rows, String sort, String order, String key, String begintime, String endtime, int type) throws Exception {
        DetachedCriteria dc = DetachedCriteria.forClass(Invoice.class);

        if (!S.isNull(key)) {
            dc.add(Restrictions.sqlRestriction("(invoicecode like '%" + key + "%' or invoicestart like '%" + key + "%'or invoiceend like '%" + key + "%')"));
        }
        if (!S.isNull(begintime)) {
            Date start = DateUtil.stringToDate(begintime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.ge("tickettime", start));
        }

        if (!S.isNull(endtime)) {
            Date end = DateUtil.stringToDate(endtime, "yyyy-MM-dd HH:mm:ss");
            dc.add(Restrictions.le("tickettime", end));
        }


        if ("desc".equals(order)) {
            dc.addOrder(Order.desc(sort));
        } else {
            dc.addOrder(Order.asc(sort));
        }
        PageList pageList = new PageList(page, rows);
        pageList = invoiceDao.findPageList(pageList, dc);
        return pageList;
    }

    @Override
    public Invoice findByid(Integer id) {
        return invoiceDao.get(id);
    }

    @Override
    public void delete(Integer id) {
        invoiceDao.delete(id);
    }

    @Override
    public void save(Invoice invoice) {
        invoiceDao.save(invoice);
    }

    @Override
    public void saveOrUpd(Invoice invoice) {
        invoiceDao.saveOrUpdate(invoice);
    }
}
