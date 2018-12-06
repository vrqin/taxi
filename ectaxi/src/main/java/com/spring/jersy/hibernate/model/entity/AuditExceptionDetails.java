package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 170.tab_audit_exception_details稽查异常明细
 * Created by Administrator on 2016/10/7.
 */
@Entity
@Table(name = "tab_audit_exception_details")
public class AuditExceptionDetails implements Serializable {
    private int id;
    private String name;//	varchar(20)			驾驶员姓名
    private String licenseid;//	varchar			驾驶证号
    private String kabnum;//	varchar			车牌号码
    private Date btime;//	varchar(20)			违章时间
    private String area;//	varchar(20)			稽查区域
    private Date starttime;//	datetime			稽查开始时间
    private Date endtime;//	datetime			稽查结束时间
    private String peoper;//	varchar(20)			稽查人员
    private String company;//	varchar(20)			所属公司
    private String transcard;//	varchar(20)			运输证号
    private int type;//	int(4)			稽查异常类型
    private String remark;//	varchar			处理备注

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "licenseid", length = 20)
    public String getLicenseid() {
        return licenseid;
    }

    public void setLicenseid(String licenseid) {
        this.licenseid = licenseid;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "btime", length = 50)
    public Date getBtime() {
        return btime;
    }

    public void setBtime(Date btime) {
        this.btime = btime;
    }

    @Column(name = "area", length = 20)
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    @Column(name = "peoper", length = 20)
    public String getPeoper() {
        return peoper;
    }

    public void setPeoper(String peoper) {
        this.peoper = peoper;
    }

    @Column(name = "company", length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "transcard", length = 20)
    public String getTranscard() {
        return transcard;
    }

    public void setTranscard(String transcard) {
        this.transcard = transcard;
    }

    @Column(name = "type", length = 4)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Column(name = "remark", length = 20)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
