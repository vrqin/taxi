package com.speedtalk.smartkab.ws.db;

import java.sql.Timestamp;

/**
 * TbTaxiOrder entity. @author MyEclipse Persistence Tools
 */
public class TbOrder implements java.io.Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 906179210233618157L;
    // Fields
    private String id;
    private Integer userid;
    private String phone;
    private String username;
    private Double srclt;
    private Double srclg;
    private String srcaddr;
    private Double dstlt;
    private Double dstlg;
    private String dstaddr;
    private Timestamp createTime;
    private Byte type;
    private Byte status;
    private Byte evaluate;
    private Float money;

    // Constructors

    /**
     * default constructor
     */
    public TbOrder() {
    }

    /**
     * minimal constructor
     */
    public TbOrder(String id, Integer userid, String phone, String username, Double srclt, Double srclg, String srcaddr, Double dstlt, Double dstlg, String dstaddr, Timestamp createTime, Byte type, Byte status) {
        this.id = id;
        this.userid = userid;
        this.phone = phone;
        this.username = username;
        this.srclt = srclt;
        this.srclg = srclg;
        this.srcaddr = srcaddr;
        this.dstlt = dstlt;
        this.dstlg = dstlg;
        this.dstaddr = dstaddr;
        this.createTime = createTime;
        this.type = type;
        this.status = status;
    }

    /**
     * full constructor
     */
    public TbOrder(String id, Integer userid, String phone, String username, Double srclt, Double srclg, String srcaddr, Double dstlt, Double dstlg, String dstaddr, Timestamp createTime, Byte type, Byte status, Byte evaluate, Float money) {
        this.id = id;
        this.userid = userid;
        this.phone = phone;
        this.username = username;
        this.srclt = srclt;
        this.srclg = srclg;
        this.srcaddr = srcaddr;
        this.dstlt = dstlt;
        this.dstlg = dstlg;
        this.dstaddr = dstaddr;
        this.createTime = createTime;
        this.type = type;
        this.status = status;
        this.evaluate = evaluate;
        this.money = money;
    }

    // Property accessors
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserid() {
        return this.userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSrclt() {
        return this.srclt;
    }

    public void setSrclt(Double srclt) {
        this.srclt = srclt;
    }

    public Double getSrclg() {
        return this.srclg;
    }

    public void setSrclg(Double srclg) {
        this.srclg = srclg;
    }

    public String getSrcaddr() {
        return this.srcaddr;
    }

    public void setSrcaddr(String srcaddr) {
        this.srcaddr = srcaddr;
    }

    public Double getDstlt() {
        return this.dstlt;
    }

    public void setDstlt(Double dstlt) {
        this.dstlt = dstlt;
    }

    public Double getDstlg() {
        return this.dstlg;
    }

    public void setDstlg(Double dstlg) {
        this.dstlg = dstlg;
    }

    public String getDstaddr() {
        return this.dstaddr;
    }

    public void setDstaddr(String dstaddr) {
        this.dstaddr = dstaddr;
    }

    public Timestamp getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Byte getType() {
        return this.type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return this.status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getEvaluate() {
        return this.evaluate;
    }

    public void setEvaluate(Byte evaluate) {
        this.evaluate = evaluate;
    }

    public Float getMoney() {
        return this.money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}
