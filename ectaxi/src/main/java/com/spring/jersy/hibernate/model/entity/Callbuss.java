package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * 电召单
 */
@Entity
@Table(name = "tab_phonecallbuss")
@XmlRootElement
public class Callbuss implements Serializable {
    private static final long serialVersionUID = -131312312312321L;
    private String billid; //'单号;主键'
    private Integer enterpriseid; //'企业ID'
    private Integer islock; //'是否被锁定: 0:未锁定 1:锁定'
    private String locker; //''
    private Integer status; //'状态: 0新业务 1:已下呼 2:已租车 3:已取消 4:已完成',5,附近没车
    private String opruser; //''创建人账号''
    private String callnumber; //'来电号码'
    private Date calltime; //'来电时间' 创建时间
    private String clientname; //'客户名'
    private Integer clientsex; //'客户性别:  0:男 1:女'
    private String address; //'目的地电召地址'
    private String clientmobile; //'客户手机号码'
    private Date usecarde; //'用车时间'
    private String carbox; //'应召车辆名称'
    private String msid; //'终端ID'
    private Date answerde; //'应召时间'
    private Double lg; //'目的地经度'
    private Double lt; //'目的地纬度'
    private String remark; //'备注'
    private Double srclt; //'出发地纬度'
    private Double srclg; //'出发地经度'
    private String srcaddr; //'出发地址'
    private Integer type; //'电召类型：0实时;1预约'
    private Integer evaluate; //'评分：1-5星'
    private Float money; //'金额'
    //    private Integer curtime; //''
    private String driverphone; //乘客电话
    private Driver driver;//一对duo
    private Integer orderType;//0 app,1微信，2电话3电话语言
    //    private OrderType orderType=new OrderType(0,"app");//登录方式
    private int timedifference;//时间差
    private int paytype = 0;//支付方式0现金1支付宝2微信


    public Callbuss() {
    }


    @Id
    @Column(name = "billid", unique = true, nullable = false, length = 19)
    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    @Column(name = "enterpriseid", length = 5)
    public Integer getEnterpriseid() {
        return enterpriseid;
    }

    public void setEnterpriseid(Integer enterpriseid) {
        this.enterpriseid = enterpriseid;
    }

    @Column(name = "islock", length = 2)
    public Integer getIslock() {
        return islock;
    }

    public void setIslock(Integer islock) {
        this.islock = islock;
    }

    @Column(name = "locker", length = 21)
    public String getLocker() {
        return locker;
    }

    public void setLocker(String locker) {
        this.locker = locker;
    }

    @Column(name = "status", length = 2)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "opruser", length = 21)
    public String getOpruser() {
        return opruser;
    }

    public void setOpruser(String opruser) {
        this.opruser = opruser;
    }

    @Column(name = "callnumber", length = 20)
    public String getCallnumber() {
        return callnumber;
    }

    public void setCallnumber(String callnumber) {
        this.callnumber = callnumber;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "calltime", length = 50)
    public Date getCalltime() {
        return calltime;
    }

    public void setCalltime(Date calltime) {
        this.calltime = calltime;
    }

    @Column(name = "clientname", length = 50)
    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    @Column(name = "clientsex", length = 2)
    public Integer getClientsex() {
        return clientsex;
    }

    public void setClientsex(Integer clientsex) {
        this.clientsex = clientsex;
    }

    @Column(name = "address", length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "clientmobile", length = 20)
    public String getClientmobile() {
        return clientmobile;
    }

    public void setClientmobile(String clientmobile) {
        this.clientmobile = clientmobile;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "usecarde", length = 50)
    public Date getUsecarde() {
        return usecarde;
    }

    public void setUsecarde(Date usecarde) {
        this.usecarde = usecarde;
    }

    @Column(name = "carbox", length = 20)
    public String getCarbox() {
        return carbox;
    }

    public void setCarbox(String carbox) {
        this.carbox = carbox;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "msid", referencedColumnName = "msid")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "answerde", length = 50)
    public Date getAnswerde() {
        return answerde;
    }

    public void setAnswerde(Date answerde) {
        this.answerde = answerde;
    }

    @Column(name = "lg", length = 10)
    public Double getLg() {
        return lg;
    }

    public void setLg(Double lg) {
        this.lg = lg;
    }

    @Column(name = "lt", length = 10)
    public Double getLt() {
        return lt;
    }

    public void setLt(Double lt) {
        this.lt = lt;
    }

    @Column(name = "remark", length = 100)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "srclt", length = 10)
    public Double getSrclt() {
        return srclt;
    }

    public void setSrclt(Double srclt) {
        this.srclt = srclt;
    }

    @Column(name = "srclg", length = 10)
    public Double getSrclg() {
        return srclg;
    }

    public void setSrclg(Double srclg) {
        this.srclg = srclg;
    }

    @Column(name = "srcaddr")
    public String getSrcaddr() {
        return srcaddr;
    }

    public void setSrcaddr(String srcaddr) {
        this.srcaddr = srcaddr;
    }

    @Column(name = "type", length = 4)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Column(name = "evaluate", length = 4)
    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

    @Column(name = "money")
    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Formula("(SELECT t.phone FROM tab_driver t WHERE t.msid = msid)")
    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    @Column(name = "paytype", length = 4, columnDefinition = "INT default 0")
    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    @Column(name = "orderType", length = 4)
    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Transient
    public int getTimedifference() {
        return timedifference;
    }

    public void setTimedifference(int timedifference) {
        this.timedifference = timedifference;
    }
}
