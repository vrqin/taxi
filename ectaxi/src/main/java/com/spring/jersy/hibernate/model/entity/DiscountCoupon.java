package com.spring.jersy.hibernate.model.entity;


import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * tab_discount_coupon
 * Created by sky on 15-8-19
 * <p>
 * 优惠券单
 */
@Entity
@Table(name = "tab_discount_coupon")
public class DiscountCoupon implements Serializable {
    private static final long serialVersionUID = -131312312312321L;

    private Integer id; //打车卷id
    private String name;//打车卷名称
    private Integer type;//打车卷类型 1.代金券、2.打折券
    private Double money;//金额
    private Integer valid;//打车卷有效天
    private Integer clientId;//id,自增
    private String clientName;
    private Integer discNum;//券总数， -1为不限制
    private Integer isvalid;//是否有效  0有效 1无效
    private String token;
    private Date starttime;//有效开始时间
    private Date endtime;//结束时间         定时扫描当前时间与有效时间对比，在范围类有效，在范围外无效
    private Integer daytype;//活动类型 1.新注册；2.重大节日；3.特殊纪念日
    private Double serviceConditions = 50.0;// 使用条件 优惠券在车费到达一定金额才能使用
    private Double maxDeduction = 20.0;// 最大抵扣金额
    private String discountPic;   //优惠券图片
    private String discountAddr;   //优惠券地址
    private Date creattime;


    @Id
    @Column(name = "id", unique = true, nullable = false, length = 20)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "type", length = 20)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "money", columnDefinition = "double(10,2) default '0'")
    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Column(name = "valid", length = 20)
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
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

    @Column(name = "clientId", length = 20)
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Column(name = "discNum", length = 20)
    public Integer getDiscNum() {
        return discNum;
    }

    public void setDiscNum(Integer discNum) {
        this.discNum = discNum;
    }

    @Column(name = "isvalid", length = 4)
    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    @Column(name = "daytype", length = 4)
    public Integer getDaytype() {
        return daytype;
    }

    public void setDaytype(Integer daytype) {
        this.daytype = daytype;
    }

    @Column(name = "serviceConditions", columnDefinition = "double(10,2) default '50'")
    public Double getServiceConditions() {
        return serviceConditions;
    }

    public void setServiceConditions(Double serviceConditions) {
        this.serviceConditions = serviceConditions;
    }

    @Column(name = "maxDeduction", columnDefinition = "double(10,2) default '20'")
    public Double getMaxDeduction() {
        return maxDeduction;
    }

    public void setMaxDeduction(Double maxDeduction) {
        this.maxDeduction = maxDeduction;
    }

    @Transient
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Column(name = "discountPic", length = 255)
    public String getDiscountPic() {
        return discountPic;
    }

    public void setDiscountPic(String discountPic) {
        this.discountPic = discountPic;
    }

    @Column(name = "discountAddr", length = 255)
    public String getDiscountAddr() {
        return discountAddr;
    }

    public void setDiscountAddr(String discountAddr) {
        this.discountAddr = discountAddr;
    }
}
