package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/9/10.
 */
@Entity
@Table(name = "tab_passenger_integrity")
public class PassenIntegrity implements Serializable {

    private String phone;
    private String name;
    private Integer sex;
    private Integer integral;
    private Integer rating;
    private Integer isblacklist;//黑名单
    private Integer callnumber;
    private Integer successnumber;
    private Integer cancelnumber;
    private Integer promisenumber;
    private Date registrationtime;
    private Integer islock;//锁定
    private String remark;//备注
    private Integer clientid;


    @Id
    @Column(name = "phone", unique = true, nullable = false, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sex", length = 4)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "integral", length = 10)
    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    @Column(name = "rating", length = 10)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name = "isblacklist", length = 4)
    public Integer getIsblacklist() {
        return isblacklist;
    }

    public void setIsblacklist(Integer isblacklist) {
        this.isblacklist = isblacklist;
    }

    @Column(name = "callnumber", length = 10)
    public Integer getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(Integer callnumber) {
        this.callnumber = callnumber;
    }

    @Column(name = "successnumber", length = 10)
    public Integer getSuccessnumber() {
        return successnumber;
    }

    public void setSuccessnumber(Integer successnumber) {
        this.successnumber = successnumber;
    }

    @Column(name = "cancelnumber", length = 10)
    public Integer getCancelnumber() {
        return cancelnumber;
    }

    public void setCancelnumber(Integer cancelnumber) {
        this.cancelnumber = cancelnumber;
    }

    @Column(name = "promisenumber", length = 10)
    public Integer getPromisenumber() {
        return promisenumber;
    }

    public void setPromisenumber(Integer promisenumber) {
        this.promisenumber = promisenumber;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registrationtime", length = 50)
    public Date getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(Date registrationtime) {
        this.registrationtime = registrationtime;
    }

    @Column(name = "islock", length = 2)
    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "clientid", length = 20)
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }
}
