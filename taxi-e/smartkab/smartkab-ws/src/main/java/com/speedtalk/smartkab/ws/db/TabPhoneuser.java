package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabPhoneuser entity. @author MyEclipse Persistence Tools
 */
public class TabPhoneuser implements java.io.Serializable {
    // Fields
    private String opruser;
    private Integer tabEnterpriseInfo;
    private String name;
    private Integer sex;
    private String password;
    private String idcard;
    private String mobile;
    private Timestamp createdate;
    private String address;
    private String remark;
    private String openId;

    // Constructors

    /**
     * default constructor
     */
    public TabPhoneuser() {
    }

    /**
     * minimal constructor
     */
    public TabPhoneuser(String opruser, Integer tabEnterpriseInfo, String password) {
        this.opruser = opruser;
        this.tabEnterpriseInfo = tabEnterpriseInfo;
        this.password = password;
    }

    /**
     * full constructor
     */
    public TabPhoneuser(String opruser, Integer tabEnterpriseInfo, String name, Integer sex, String password, String idcard, String mobile, Timestamp createdate, String address, String remark, String openId) {
        this.opruser = opruser;
        this.tabEnterpriseInfo = tabEnterpriseInfo;
        this.name = name;
        this.sex = sex;
        this.password = password;
        this.idcard = idcard;
        this.mobile = mobile;
        this.createdate = createdate;
        this.address = address;
        this.remark = remark;
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "TabPhoneuser [opruser=" + opruser + ", tabEnterpriseInfo=" + tabEnterpriseInfo + ", name=" + name + ", sex=" + sex + ", password=" + password + ", idcard=" + idcard + ", mobile=" + mobile + ", createdate=" + createdate + ", address=" + address + ", remark=" + remark + ", openId=" + openId + "]";
    }

    // Property accessors
    public String getOpruser() {
        return this.opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public Integer getTabEnterpriseInfo() {
        return this.tabEnterpriseInfo;
    }

    public void setTabEnterpriseInfo(Integer tabEnterpriseInfo) {
        this.tabEnterpriseInfo = tabEnterpriseInfo;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return this.idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getCreatedate() {
        return this.createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
