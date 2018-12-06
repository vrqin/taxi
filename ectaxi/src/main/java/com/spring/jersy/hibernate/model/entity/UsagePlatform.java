package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * tab_usage_platform平台使用情况
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_usage_platform")
public class UsagePlatform implements Serializable {

    private int enterprise;//	varchar(20)			企业名称
    private int totalnum;//	int(20)			车辆总数
    private int onlinenum;//	int(20)			在线车辆数
    private int offlinenum;//	int(20)			离线车辆数
    private int emptynum;//	int(20)			空车数量
    private int heavynum;//	int(20)			重车数量
    private String company;
    private String token;

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    @Column(name = "id", unique = true, nullable = false, length = 11)
    //    public int getId() {
    //        return id;
    //    }
    //
    //    public void setId(int id) {
    //        this.id = id;
    //    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "enterprise", unique = true, nullable = false, length = 11)
    public int getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(int enterprise) {
        this.enterprise = enterprise;
    }

    @Column(name = "totalnum", length = 20)
    public int getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(int totalnum) {
        this.totalnum = totalnum;
    }

    @Column(name = "onlinenum", length = 20)
    public int getOnlinenum() {
        return onlinenum;
    }

    public void setOnlinenum(int onlinenum) {
        this.onlinenum = onlinenum;
    }

    @Column(name = "offlinenum", length = 20)
    public int getOfflinenum() {
        return offlinenum;
    }

    public void setOfflinenum(int offlinenum) {
        this.offlinenum = offlinenum;
    }

    @Column(name = "emptynum", length = 20)
    public int getEmptynum() {
        return emptynum;
    }

    public void setEmptynum(int emptynum) {
        this.emptynum = emptynum;
    }

    @Column(name = "heavynum", length = 20)
    public int getHeavynum() {
        return heavynum;
    }

    public void setHeavynum(int heavynum) {
        this.heavynum = heavynum;
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
