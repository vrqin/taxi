package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 驾驶员离线统计表
 * Created by Administrator on 2016/9/29.
 */
@Entity
@Table(name = "tab_offline_statis")
public class OfflineStatis implements Serializable {

    private int id;
    private String kabnum;   //车牌号
    private String account;   //驾驶员
    private String unit;   //所属单位
    private int cmulative;   //次数
    private int duration;   //时长(秒)


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "unit", length = 50)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "cmulative", length = 20)
    public int getCmulative() {
        return cmulative;
    }

    public void setCmulative(int cmulative) {
        this.cmulative = cmulative;
    }

    @Column(name = "duration", length = 20)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "OfflineStatis{" + "id=" + id + ", kabnum='" + kabnum + '\'' + ", account='" + account + '\'' + ", unit='" + unit + '\'' + ", cmulative=" + cmulative + ", duration=" + duration + '}';
    }
}
