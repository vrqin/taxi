package com.spring.jersy.hibernate.model.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/9/10.
 */
@Entity
@Table(name = "tab_driver_integrity")
public class DriverIntegrity implements Serializable {

    private String phone;
    private String name;
    private Integer sex;
    private String kabnum;
    private String enterprise;
    private Integer integral;
    private Integer rating;
    private Integer isblacklist;
    private Integer callnumber;
    private Integer successnumber;
    private Integer cancelnumber;
    private Integer promisenumber;
    private Integer toaccount;
    private Double tomileage;
    private Double tomoney;
    private Double tovainmileage;
    private int clientid;
    private Integer isstop;
    private Integer pubishment;


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

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "enterprise", length = 50)
    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }

    @Column(name = "integral", length = 20)
    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    @Column(name = "rating", length = 20)
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Column(name = "isblacklist", length = 4, columnDefinition = "INT default 0")
    public Integer getIsblacklist() {
        return isblacklist;
    }

    public void setIsblacklist(Integer isblacklist) {
        this.isblacklist = isblacklist;
    }

    @Column(name = "callnumber", length = 10, columnDefinition = "INT default 0")
    public Integer getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(Integer callnumber) {
        this.callnumber = callnumber;
    }

    @Column(name = "successnumber", length = 10, columnDefinition = "INT default 0")
    public Integer getSuccessnumber() {
        return successnumber;
    }

    public void setSuccessnumber(Integer successnumber) {
        this.successnumber = successnumber;
    }

    @Column(name = "cancelnumber", length = 10, columnDefinition = "INT default 0")
    public Integer getCancelnumber() {
        return cancelnumber;
    }

    public void setCancelnumber(Integer cancelnumber) {
        this.cancelnumber = cancelnumber;
    }

    @Column(name = "promisenumber", length = 10, columnDefinition = "INT default 0")
    public Integer getPromisenumber() {
        return promisenumber;
    }

    public void setPromisenumber(Integer promisenumber) {
        this.promisenumber = promisenumber;
    }

    @Column(name = "toaccount", length = 10, columnDefinition = "INT default 0")
    public Integer getToaccount() {
        return toaccount;
    }

    public void setToaccount(Integer toaccount) {
        this.toaccount = toaccount;
    }

    @Column(name = "tomileage", length = 10, columnDefinition = "INT default 0")
    public Double getTomileage() {
        return tomileage;
    }

    public void setTomileage(Double tomileage) {
        this.tomileage = tomileage;
    }

    @Column(name = "tomoney", length = 10, columnDefinition = "INT default 0")
    public Double getTomoney() {
        return tomoney;
    }

    public void setTomoney(Double tomoney) {
        this.tomoney = tomoney;
    }

    @Column(name = "tovainmileage", length = 10, columnDefinition = "INT default 0")
    public Double getTovainmileage() {
        return tovainmileage;
    }

    public void setTovainmileage(Double tovainmileage) {
        this.tovainmileage = tovainmileage;
    }

    @Column(name = "clientid", length = 20)
    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @Transient
    public Integer getIsstop() {
        return isstop;
    }

    public void setIsstop(Integer isstop) {
        this.isstop = isstop;
    }

    @Transient
    public Integer getPubishment() {
        return pubishment;
    }

    public void setPubishment(Integer pubishment) {
        this.pubishment = pubishment;
    }
}
