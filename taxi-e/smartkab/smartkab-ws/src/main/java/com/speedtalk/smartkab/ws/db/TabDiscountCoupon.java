package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TabDiscountCoupon entity. @author MyEclipse Persistence Tools
 */
public class TabDiscountCoupon implements java.io.Serializable {
    // Fields
    private Long id;
    //	private Integer clientId;
    private Timestamp endtime;
    private Double money;
    //	private String name;
    private Timestamp starttime;
    private Integer type;
    private Integer valid;
    //	private Integer discNum;
    //	private Integer isvalid;
    //	private Integer daytype;
    private Double deduction;
    private Double condition;

    // Constructors

    /**
     * default constructor
     */
    public TabDiscountCoupon() {
    }

    /**
     * full constructor
     */
    public TabDiscountCoupon(/*Integer clientId,*/Timestamp endtime, Double money,
            /*String name,*/Timestamp starttime, Integer type, Integer valid/*,
			Integer discNum,Integer isvalid,Integer daytype*/, Double deduction, Double condition) {
        //		this.clientId = clientId;
        this.endtime = endtime;
        this.money = money;
        //		this.name = name;
        this.starttime = starttime;
        this.type = type;
        this.valid = valid;
        //		this.discNum = discNum;
        //		this.isvalid = isvalid;
        //		this.daytype = daytype;
        this.deduction = deduction;
        this.condition = condition;
    }

    // Property accessors
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //	public Integer getClientId()
    //	{
    //		return this.clientId;
    //	}
    //	public void setClientId(Integer clientId)
    //	{
    //		this.clientId = clientId;
    //	}
    public Timestamp getEndtime() {
        return this.endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public Double getMoney() {
        return this.money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    //	public String getName()
    //	{
    //		return this.name;
    //	}
    //	public void setName(String name)
    //	{
    //		this.name = name;
    //	}
    public Timestamp getStarttime() {
        return this.starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getValid() {
        return this.valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    //	public Integer getDiscNum()
    //	{
    //		return this.discNum;
    //	}
    //	public void setDiscNum(Integer discNum)
    //	{
    //		this.discNum = discNum;
    //	}
    //	public Integer getIsvalid()
    //	{
    //		return this.isvalid;
    //	}
    //	public void setIsvalid(Integer isvalid)
    //	{
    //		this.isvalid = isvalid;
    //	}
    //	public Integer getDaytype()
    //	{
    //		return this.daytype;
    //	}
    //	public void setDaytype(Integer daytype)
    //	{
    //		this.daytype = daytype;
    //	}
    public Double getDeduction() {
        return deduction;
    }

    public void setDeduction(Double deduction) {
        this.deduction = deduction;
    }

    public Double getCondition() {
        return condition;
    }

    public void setCondition(Double condition) {
        this.condition = condition;
    }
}