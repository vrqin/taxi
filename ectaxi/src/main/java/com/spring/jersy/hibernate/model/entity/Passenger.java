package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 乘客
 */
@Entity
@Table(name = "tab_phoneuser")
public class Passenger implements Serializable {
    private static final long serialVersionUID = -131312312312321L;

    private String opruser; //用户账号;ID;主键
    private Integer enterpriseid;//企业ID
    private String name;//姓名
    private Integer sex;//性别 0：男；1：女
    private String password;//密码
    private String idcard;//身份证号
    private String mobile;//电话号码
    private Date createdate;//创建时间
    //    private Integer curtime;//
    private String address;//联系地址
    private String remark;//备注
    private Integer type = 0;//类型0：乘客  1：坐席
    private String openId; //微信公众号
    private Integer islock = 0;//是否锁定 0:否，1:是

    @Id
    @Column(name = "opruser", unique = true, nullable = false, length = 21)
    public String getOpruser() {
        return opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    @Column(name = "enterpriseid", length = 5)
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sex", length = 2)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "password", length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "idcard", length = 20)
    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    @Column(name = "mobile", length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdate", length = 50)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    //    @Column(name = "curtime", length = 20)
    //    public Integer getCurtime() {
    //        return curtime;
    //    }
    //
    //    public void setCurtime(Integer curtime) {
    //        this.curtime = curtime;
    //    }

    @Column(name = "address", length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "remark", length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "openId")
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Column(name = "type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "islock")
    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    @Override
    public String toString() {
        return "Passenger{" + "opruser='" + opruser + '\'' + ", enterpriseid=" + enterpriseid + ", name='" + name + '\'' + ", sex=" + sex + ", password='" + password + '\'' + ", idcard='" + idcard + '\'' + ", mobile='" + mobile + '\'' + ", createdate=" + createdate +
                //                ", curtime=" + curtime +
                ", address='" + address + '\'' + ", remark='" + remark + '\'' + ", type=" + type + ", openId='" + openId + '\'' + '}';
    }
}
