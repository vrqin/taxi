package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 运营收入统计信息表
 * Created by Administrator on 2016/9/5.
 */
@Entity
@Table(name = "tab_operat_statis")
public class OperatStatis implements Serializable {

    //    private Integer id;
    private String kabnum; //车牌号
    private String name; //驾驶员姓名
    private int enterprise;//企业名称
    private Double passmile;//载客里程
    private Double emptymile;//空驶里程
    private Double amount;//交易金额
    private String company;
    private String token;


    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    @Column(name = "id",unique = true,nullable = false,length = 11)
    //    public Integer getId() {
    //        return id;
    //    }
    //
    //    public void setId(Integer id) {
    //        this.id = id;
    //    }
    @Id
    @Column(name = "kabnum", unique = true, nullable = false, length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "enterprise", length = 50)
    public int getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(int enterprise) {
        this.enterprise = enterprise;
    }

    @Column(name = "passmile", length = 20, scale = 2)
    public Double getPassmile() {
        return passmile;
    }

    public void setPassmile(Double passmile) {
        this.passmile = passmile;
    }

    @Column(name = "emptymile", length = 20, scale = 2)
    public Double getEmptymile() {
        return emptymile;
    }

    public void setEmptymile(Double emptymile) {
        this.emptymile = emptymile;
    }

    @Column(name = "amount", length = 20, scale = 2)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Transient
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
