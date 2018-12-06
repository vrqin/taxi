package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 企业小费统计信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_enterprise_tip_statis_day")
public class EnterpriseTipStatisDay implements Serializable {
    private Integer id;
    private String date;
    private Double amount;
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

    @Column(name = "date", length = 50)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Column(name = "amount", length = 20)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "company", length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
