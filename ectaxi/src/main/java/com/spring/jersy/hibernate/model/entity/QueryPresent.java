package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 51.	tab_query_present交接班查询
 * Created by Administrator on 2016/10/6.
 */
@Entity
@Table(name = "tab_query_present")
public class QueryPresent implements Serializable {
    private int id;
    private String name;//	varchar(20)			驾驶员姓名
    private Date geton;//		datetime			上班时间
    private Date getoff;//		datetime			交班时间
    private String phone;//		varchar(20)			驾驶员手机号
    private String account;//	varchar(20)			驾驶员帐号
    private String seniority;//		varchar(20)			从业资格证号
    private String kabnum;//	;//		varchar(20)			车牌号
    private String devicenum;//		varchar(20)			设备号
    private String company;//		varchar(20)			所属公司
    private String units;//		varchar(20)			所属单位
    private int flag;//		int(2)			是否错时交班,0否，1是

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

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "geton", length = 50)
    public Date getGeton() {
        return geton;
    }

    public void setGeton(Date geton) {
        this.geton = geton;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "getoff", length = 50)
    public Date getGetoff() {
        return getoff;
    }

    public void setGetoff(Date getoff) {
        this.getoff = getoff;
    }

    @Column(name = "phone", length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "seniority", length = 20)
    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "devicenum", length = 20)
    public String getDevicenum() {
        return devicenum;
    }

    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum;
    }

    @Column(name = "company", length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "units", length = 20)
    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    @Column(name = "flag", length = 2)
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
