package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * tab_regional_police_details
 * 区域报警明细信息表
 * Created by Administrator on 2016/9/30.
 */
@Entity
@Table(name = "tab_regional_police_details")
public class RegionalPoliceDetails implements Serializable {
    private int id;
    private String kabnum;//	varchar(20)			车牌号码
    private String account;//	varchar(20)			驾驶员
    private String unit;//	varchar(50)			所属单位
    private String area;//	varchar(20)			区域名称
    private int type;//	int(4)			报警类型
    private Date starttime;//	datetime			开始时间
    private Date endtime;//	datetime			结束时间
    private Date creattime;//	datetime			时间
    private String address;//	varchar(50)			异常地点

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

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Column(name = "type", length = 4)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "starttime", length = 50)
    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "endtime", length = 50)
    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creattime", length = 50)
    public Date getCreattime() {
        return creattime;
    }

    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}