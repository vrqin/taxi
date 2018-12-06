package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 发票管理信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_invoice")
public class Invoice implements Serializable {

    private Integer id;
    private String invoicecode;
    private String invoicestart;
    private String invoiceend;
    private String ledholder;
    private Date tickettime;
    private String remarke;
    private String token;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "invoicecode", length = 20)
    public String getInvoicecode() {
        return invoicecode;
    }

    public void setInvoicecode(String invoicecode) {
        this.invoicecode = invoicecode;
    }

    @Column(name = "invoicestart", length = 20)
    public String getInvoicestart() {
        return invoicestart;
    }

    public void setInvoicestart(String invoicestart) {
        this.invoicestart = invoicestart;
    }

    @Column(name = "invoiceend", length = 20)
    public String getInvoiceend() {
        return invoiceend;
    }

    public void setInvoiceend(String invoiceend) {
        this.invoiceend = invoiceend;
    }

    @Column(name = "ledholder", length = 20)
    public String getLedholder() {
        return ledholder;
    }

    public void setLedholder(String ledholder) {
        this.ledholder = ledholder;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "tickettime", length = 50)
    public Date getTickettime() {
        return tickettime;
    }

    public void setTickettime(Date tickettime) {
        this.tickettime = tickettime;
    }

    @Column(name = "remarke")
    public String getRemarke() {
        return remarke;
    }

    public void setRemarke(String remarke) {
        this.remarke = remarke;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
