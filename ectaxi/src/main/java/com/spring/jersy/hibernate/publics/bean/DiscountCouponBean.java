package com.spring.jersy.hibernate.publics.bean;

/**
 * Created by x1c on 2017/7/17.
 */
public class DiscountCouponBean {
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
    private String starttime;//有效开始时间
    private String endtime;//结束时间         定时扫描当前时间与有效时间对比，在范围类有效，在范围外无效
    private Integer daytype;//活动类型 1.新注册；2.重大节日；3.特殊纪念日
    private Double serviceConditions = 50.0;// 使用条件 优惠券在车费到达一定金额才能使用
    private Double maxDeduction = 20.0;// 最大抵扣金额
    private Integer carstatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getDiscNum() {
        return discNum;
    }

    public void setDiscNum(Integer discNum) {
        this.discNum = discNum;
    }

    public Integer getIsvalid() {
        return isvalid;
    }

    public void setIsvalid(Integer isvalid) {
        this.isvalid = isvalid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Integer getDaytype() {
        return daytype;
    }

    public void setDaytype(Integer daytype) {
        this.daytype = daytype;
    }

    public Double getServiceConditions() {
        return serviceConditions;
    }

    public void setServiceConditions(Double serviceConditions) {
        this.serviceConditions = serviceConditions;
    }

    public Double getMaxDeduction() {
        return maxDeduction;
    }

    public void setMaxDeduction(Double maxDeduction) {
        this.maxDeduction = maxDeduction;
    }

    public Integer getCarstatus() {
        return carstatus;
    }

    public void setCarstatus(Integer carstatus) {
        this.carstatus = carstatus;
    }
}
