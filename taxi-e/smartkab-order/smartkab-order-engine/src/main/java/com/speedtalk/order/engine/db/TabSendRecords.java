package com.speedtalk.order.engine.db;

/**
 * TabSendRecords entity. @author MyEclipse Persistence Tools
 */
public class TabSendRecords implements java.io.Serializable {
    // Fields
    private Integer id;
    private String ordernum;
    private String driver;
    private Double lg;
    private Double lt;
    private Byte iscarry;

    // Constructors

    /**
     * default constructor
     */
    public TabSendRecords() {
    }

    /**
     * minimal constructor
     */
    public TabSendRecords(String ordernum, String driver) {
        this.ordernum = ordernum;
        this.driver = driver;
    }

    /**
     * full constructor
     */
    public TabSendRecords(String ordernum, String driver, Double lg, Double lt, Byte iscarry) {
        this.ordernum = ordernum;
        this.driver = driver;
        this.lg = lg;
        this.lt = lt;
        this.iscarry = iscarry;
    }

    // Property accessors
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernum() {
        return this.ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getDriver() {
        return this.driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Double getLg() {
        return this.lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    public Double getLt() {
        return this.lt;
    }

    public void setLt(Double lt) {
        this.lt = lt;
    }

    public Byte getIscarry() {
        return this.iscarry;
    }

    public void setIscarry(Byte iscarry) {
        this.iscarry = iscarry;
    }
}
