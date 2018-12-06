package com.speedtalk.smartkab.ws.db;

/**
 * TbPrice entity. @author MyEclipse Persistence Tools
 */
public class TbPrice implements java.io.Serializable {
    // Fields
    private Integer id;
    private String province;
    private String city;
    private Integer nightinitial;
    private Integer nightend;
    private Float initialmeter;
    private Float dayinitialprice;
    private Float nightinitialprice;
    private Float dayincreasemeter;
    private Float dayincreaseprice;
    private Float nightincreasemeter;
    private Float nightincreaseprice;
    private Float highpricemeter;
    private Float dayhighprice;
    private Float nighthighprice;
    //	private String remark;

    // Constructors

    /**
     * default constructor
     */
    public TbPrice() {
    }

    /**
     * full constructor
     */
    public TbPrice(String province, String city, Integer nightinitial, Integer nightend, Float initialmeter, Float dayinitialprice, Float nightinitialprice, Float dayincreasemeter, Float dayincreaseprice, Float nightincreasemeter, Float nightincreaseprice, Float highpricemeter, Float dayhighprice, Float nighthighprice) {
        this.province = province;
        this.city = city;
        this.nightinitial = nightinitial;
        this.nightend = nightend;
        this.initialmeter = initialmeter;
        this.dayinitialprice = dayinitialprice;
        this.nightinitialprice = nightinitialprice;
        this.dayincreasemeter = dayincreasemeter;
        this.dayincreaseprice = dayincreaseprice;
        this.nightincreasemeter = nightincreasemeter;
        this.nightincreaseprice = nightincreaseprice;
        this.highpricemeter = highpricemeter;
        this.dayhighprice = dayhighprice;
        this.nighthighprice = nighthighprice;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNightinitial() {
        return this.nightinitial;
    }

    public void setNightinitial(Integer nightinitial) {
        this.nightinitial = nightinitial;
    }

    public Integer getNightend() {
        return this.nightend;
    }

    public void setNightend(Integer nightend) {
        this.nightend = nightend;
    }

    public Float getInitialmeter() {
        return initialmeter;
    }

    public void setInitialmeter(Float initialmeter) {
        this.initialmeter = initialmeter;
    }

    public Float getDayinitialprice() {
        return this.dayinitialprice;
    }

    public void setDayinitialprice(Float dayinitialprice) {
        this.dayinitialprice = dayinitialprice;
    }

    public Float getNightinitialprice() {
        return this.nightinitialprice;
    }

    public void setNightinitialprice(Float nightinitialprice) {
        this.nightinitialprice = nightinitialprice;
    }

    public Float getDayincreasemeter() {
        return this.dayincreasemeter;
    }

    public void setDayincreasemeter(Float dayincreasemeter) {
        this.dayincreasemeter = dayincreasemeter;
    }

    public Float getDayincreaseprice() {
        return this.dayincreaseprice;
    }

    public void setDayincreaseprice(Float dayincreaseprice) {
        this.dayincreaseprice = dayincreaseprice;
    }

    public Float getNightincreasemeter() {
        return this.nightincreasemeter;
    }

    public void setNightincreasemeter(Float nightincreasemeter) {
        this.nightincreasemeter = nightincreasemeter;
    }

    public Float getNightincreaseprice() {
        return this.nightincreaseprice;
    }

    public void setNightincreaseprice(Float nightincreaseprice) {
        this.nightincreaseprice = nightincreaseprice;
    }

    public Float getHighpricemeter() {
        return this.highpricemeter;
    }

    public void setHighpricemeter(Float highpricemeter) {
        this.highpricemeter = highpricemeter;
    }

    public Float getDayhighprice() {
        return this.dayhighprice;
    }

    public void setDayhighprice(Float dayhighprice) {
        this.dayhighprice = dayhighprice;
    }

    public Float getNighthighprice() {
        return this.nighthighprice;
    }

    public void setNighthighprice(Float nighthighprice) {
        this.nighthighprice = nighthighprice;
    }
    //	public String getRemark()
    //	{
    //		return this.remark;
    //	}
    //	public void setRemark(String remark)
    //	{
    //		this.remark = remark;
    //	}
}