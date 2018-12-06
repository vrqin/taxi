package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 提现统计信息表 年度
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_withdraw_statis_day")
public class WithdrawStatisDay implements Serializable {
    private Integer id;
    private Date statisticaltime;
    private Double amount;
    private String date;
    private String company;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "statisticaltime", length = 50)
    public Date getStatisticaltime() {
        return statisticaltime;
    }

    public void setStatisticaltime(Date statisticaltime) {
        this.statisticaltime = statisticaltime;
    }

    @Column(name = "amount", length = 20)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "date", length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "company", length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
