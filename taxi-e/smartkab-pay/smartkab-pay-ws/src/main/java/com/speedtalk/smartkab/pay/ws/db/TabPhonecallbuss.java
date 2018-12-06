package com.speedtalk.smartkab.pay.ws.db;

import java.sql.Timestamp;


/**
 * TabPhonecallbuss entity. @author MyEclipse Persistence Tools
 */

public class TabPhonecallbuss implements java.io.Serializable {


    // Fields    

    private String billid;
    //     private TabOrderType tabOrderType;
    //     private Integer enterpriseid;
    //     private Integer islock;
    //     private String locker;
    //     private Integer status;
    private String opruser;
    private String callnumber;
    private Timestamp calltime;
    //     private String clientname;
    //     private Integer clientsex;
    private String address;
    private String clientmobile;
    //     private Timestamp usecarde;
    private String carbox;
    private String msid;
    //     private Timestamp answerde;
    private Double lg;
    private Double lt;
    //     private String remark;
    private Double srclt;
    private Double srclg;
    private String srcaddr;
    private Short type;
    //     private Short evaluate;
    private Float money;
    //     private Timestamp curtime;


    // Constructors

    /**
     * default constructor
     */
    public TabPhonecallbuss() {
    }

    /**
     * full constructor
     */
    public TabPhonecallbuss(String billid, /*TabOrderType tabOrderType, 
    		Integer enterpriseid, Integer islock, String locker, 
    		Integer status,*/ String opruser, String callnumber, Timestamp calltime, /*String clientname, Integer clientsex,*/
                            String address, String clientmobile, /*Timestamp usecarde,*/
                            String carbox, String msid, /*Timestamp answerde,*/ Double lg, Double lt, /*String remark,*/ Double srclt, Double srclg, String srcaddr, Short type, /*Short evaluate,*/ Float money/*,
    		Timestamp curtime*/) {
        this.billid = billid;
        //        this.tabOrderType = tabOrderType;
        //        this.enterpriseid = enterpriseid;
        //        this.islock = islock;
        //        this.locker = locker;
        //        this.status = status;
        this.opruser = opruser;
        this.callnumber = callnumber;
        this.calltime = calltime;
        //        this.clientname = clientname;
        //        this.clientsex = clientsex;
        this.address = address;
        this.clientmobile = clientmobile;
        //        this.usecarde = usecarde;
        this.carbox = carbox;
        this.msid = msid;
        //        this.answerde = answerde;
        this.lg = lg;
        this.lt = lt;
        //        this.remark = remark;
        this.srclt = srclt;
        this.srclg = srclg;
        this.srcaddr = srcaddr;
        this.type = type;
        //        this.evaluate = evaluate;
        this.money = money;
        //        this.curtime = curtime;
    }


    // Property accessors

    public String getBillid() {
        return this.billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    //    public TabOrderType getTabOrderType() {
    //        return this.tabOrderType;
    //    }
    //
    //    public void setTabOrderType(TabOrderType tabOrderType) {
    //        this.tabOrderType = tabOrderType;
    //    }
    //
    //    public Integer getEnterpriseid() {
    //        return this.enterpriseid;
    //    }
    //
    //    public void setEnterpriseid(Integer enterpriseid) {
    //        this.enterpriseid = enterpriseid;
    //    }
    //
    //    public Integer getIslock() {
    //        return this.islock;
    //    }
    //
    //    public void setIslock(Integer islock) {
    //        this.islock = islock;
    //    }
    //
    //    public String getLocker() {
    //        return this.locker;
    //    }
    //
    //    public void setLocker(String locker) {
    //        this.locker = locker;
    //    }
    //
    //    public Integer getStatus() {
    //        return this.status;
    //    }
    //
    //    public void setStatus(Integer status) {
    //        this.status = status;
    //    }

    public String getOpruser() {
        return this.opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    public String getCallnumber() {
        return this.callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    public Timestamp getCalltime() {
        return this.calltime;
    }

    public void setCalltime(Timestamp calltime) {
        this.calltime = calltime;
    }

    //    public String getClientname() {
    //        return this.clientname;
    //    }
    //
    //    public void setClientname(String clientname) {
    //        this.clientname = clientname;
    //    }
    //
    //    public Integer getClientsex() {
    //        return this.clientsex;
    //    }
    //
    //    public void setClientsex(Integer clientsex) {
    //        this.clientsex = clientsex;
    //    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getClientmobile() {
        return this.clientmobile;
    }

    public void setClientmobile(String clientmobile) {
        this.clientmobile = clientmobile;
    }

    //    public Timestamp getUsecarde() {
    //        return this.usecarde;
    //    }
    //
    //    public void setUsecarde(Timestamp usecarde) {
    //        this.usecarde = usecarde;
    //    }

    public String getCarbox() {
        return this.carbox;
    }

    public void setCarbox(String carbox) {
        this.carbox = carbox;
    }

    public String getMsid() {
        return this.msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    //    public Timestamp getAnswerde() {
    //        return this.answerde;
    //    }
    //
    //    public void setAnswerde(Timestamp answerde) {
    //        this.answerde = answerde;
    //    }

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

    //    public String getRemark() {
    //        return this.remark;
    //    }
    //
    //    public void setRemark(String remark) {
    //        this.remark = remark;
    //    }

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

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    //    public Short getEvaluate() {
    //        return this.evaluate;
    //    }
    //
    //    public void setEvaluate(Short evaluate) {
    //        this.evaluate = evaluate;
    //    }

    public Float getMoney() {
        return this.money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "TabPhonecallbuss [billid=" + billid + ", opruser=" + opruser + ", callnumber=" + callnumber + ", calltime=" + calltime + ", address=" + address + ", clientmobile=" + clientmobile + ", carbox=" + carbox + ", msid=" + msid + ", lg=" + lg + ", lt=" + lt + ", srclt=" + srclt + ", srclg=" + srclg + ", srcaddr=" + srcaddr + ", type=" + type + ", money=" + money + "]";
    }

    //    public Timestamp getCurtime() {
    //        return this.curtime;
    //    }
    //
    //    public void setCurtime(Timestamp curtime) {
    //        this.curtime = curtime;
    //    }

}