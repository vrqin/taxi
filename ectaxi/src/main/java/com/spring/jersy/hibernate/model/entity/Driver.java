package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.hibernate.annotations.Cascade;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 司机
 */
@Entity
@Table(name = "tab_driver")
public class Driver implements Serializable, Comparable<Driver> {
    private static final long serialVersionUID = -131312312312321L;

    private Integer driverid;
    private String account;//司机APP登录账号
    private String pwd;//司机APP登录密码
    private String msid;//
    private String kabnum;//车牌号
    private String name;//司机名称
    private Integer sex;//司机性别：0：男 1：女
    private String phone;//司机联系电话
    private Date createtime;//
    private Date curtime;//
    private Double lastlg;//车辆经度
    private Double lastlt;//车辆纬度
    private Date gpstime;//上传定位的时间
    private Integer isonline;//0：不在线；1：在线
    private Integer isdel;//0:存在，1：删除
    private String company;//所属出租车公司',
    private Integer isstop = 0;//是否禁用账号：0，可使用；1，禁用
    private String driverPic; //司机图片
    private String driveridentityPic; //司机图片
    private String drivingPic; //司机图片
    private String identity;//身份证
    private String OperationID;//运营证号
    private String LicenseID;//驾驶证号
    private String starLevel;//星级
    private String driverCardID;//司机卡ID
    private String serialNum;//编号
    private Date validityDatetime;//有效期
    private Integer clientid;//所属公司编码
    private Integer kabnumid;//所属车辆Id;
    private Integer remain; //充值次数
    private String token;
    //    private String cashaccount;//提现账户
    ////    private transient Carinfo carinfo;

    private Carinfo carinfo;       //司机用那些车辆


    public Driver() {
    }

    public Driver(String msid) {
        this.msid = msid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false, length = 11)
    public Integer getDriverid() {
        return driverid;
    }

    public void setDriverid(Integer driverid) {
        this.driverid = driverid;
    }

    @Column(name = "account", length = 20)
    public String getAccount() {
        return account;
    }


    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "pwd", length = 20)
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Column(name = "msid", length = 22)
    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    @Column(name = "kabnum", length = 20)
    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    @Column(name = "name", length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sex", length = 1)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Column(name = "phone", length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "identity", length = 50)
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createtime", length = 50)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Transactional
    public Date getCurtime() {
        return curtime;
    }

    public void setCurtime(Date curtime) {
        this.curtime = curtime;
    }

    @Column(name = "lastlg", length = 20)
    public Double getLastlg() {
        return lastlg;
    }

    public void setLastlg(Double lastlg) {
        this.lastlg = lastlg;
    }

    @Column(name = "lastlt", length = 20)
    public Double getLastlt() {
        return lastlt;
    }

    public void setLastlt(Double lastlt) {
        this.lastlt = lastlt;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gpstime", length = 50)
    public Date getGpstime() {
        return gpstime;
    }

    public void setGpstime(Date gpstime) {
        this.gpstime = gpstime;
    }

    @Column(name = "isonline", length = 1)
    public Integer getIsonline() {
        return isonline;
    }

    public void setIsonline(Integer isonline) {
        this.isonline = isonline;
    }

    @Column(name = "company", length = 60)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "isstop", length = 4)
    public Integer getIsstop() {
        return isstop;
    }

    public void setIsstop(Integer isstop) {
        this.isstop = isstop;
    }

    @Column(name = "driverpic", length = 255)
    public String getDriverPic() {
        return driverPic;
    }

    public void setDriverPic(String driverPic) {
        this.driverPic = driverPic;
    }

    @Column(name = "operationid", length = 50)
    public String getOperationID() {
        return OperationID;
    }

    public void setOperationID(String operationID) {
        OperationID = operationID;
    }

    @Column(name = "licenseid", length = 50)
    public String getLicenseID() {
        return LicenseID;
    }

    public void setLicenseID(String licenseID) {
        LicenseID = licenseID;
    }

    @Column(name = "starlevel", length = 50)
    public String getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(String starLevel) {
        this.starLevel = starLevel;
    }

    @Column(name = "drivercardid", length = 50)
    public String getDriverCardID() {
        return driverCardID;
    }

    public void setDriverCardID(String driverCardID) {
        this.driverCardID = driverCardID;
    }

    @Column(name = "serialnum", length = 50)
    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "validitydatetime", length = 50)
    public Date getValidityDatetime() {
        return validityDatetime;
    }

    public void setValidityDatetime(Date validityDatetime) {
        this.validityDatetime = validityDatetime;
    }

    @Column(name = "clientid", length = 50)
    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    @Column(name = "driveridentityPic", length = 255)
    public String getDriveridentityPic() {
        return driveridentityPic;
    }

    public void setDriveridentityPic(String driveridentityPic) {
        this.driveridentityPic = driveridentityPic;
    }

    @Column(name = "drivingPic", length = 255)
    public String getDrivingPic() {
        return drivingPic;
    }

    public void setDrivingPic(String drivingPic) {
        this.drivingPic = drivingPic;
    }

    @Column(name = "kabnumid", length = 4)
    public Integer getKabnumid() {
        return kabnumid;
    }

    public void setKabnumid(Integer kabnumid) {
        this.kabnumid = kabnumid;
    }

    @Column(name = "isdel", length = 4, columnDefinition = "INT default 0")
    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }


    @Column(name = "remain", length = 20, columnDefinition = "INT default 1000")
    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    //    @Column(name = "cashaccount", length = 50 )
    //    public String getCashaccount() {
    //        return cashaccount;
    //    }
    //
    //    public void setCashaccount(String cashaccount) {
    //        this.cashaccount = cashaccount;
    //    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    //    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = true)
    //    @JoinColumn(name = "carinfoid")
    //    public Carinfo getCarinfo() {
    //        return carinfo;
    //    }
    //
    //    public void setCarinfo(Carinfo carinfo) {
    //        this.carinfo = carinfo;
    //    }

    //    @ManyToMany(cascade=CascadeType.PERSIST,fetch = FetchType.EAGER)
    //    @JoinTable(
    ////      设置中间表名
    //            name="tab_carinfo_driver",
    ////      指定当前对象的外键,本表在中间表的外键名称
    //            joinColumns={@JoinColumn(name="driverid",referencedColumnName="id")},
    ////      指定关联对象的外键,另一个表在中间表的外键名称。
    //            inverseJoinColumns={@JoinColumn(name="id",referencedColumnName="id")}
    //    )
    //    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER,mappedBy="driverHashSet")
    //@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE},fetch = FetchType.EAGER)
    //@OneToMany(mappedBy = "driverHashSet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(
            //      设置中间表名
            name = "tab_carinfo_driver",
            //      指定当前对象的外键,本表在中间表的外键名称
            joinColumns = {@JoinColumn(name = "driverid", referencedColumnName = "id")},
            //      指定关联对象的外键,另一个表在中间表的外键名称。
            inverseJoinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")})
    @JsonBackReference
    public Carinfo getCarinfo() {
        return carinfo;
    }

    public void setCarinfo(Carinfo carinfo) {
        this.carinfo = carinfo;
    }

    @Override
    public int compareTo(Driver o) {
        return o.getGpstime().compareTo(this.getGpstime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Driver))
            return false;

        Driver driver = (Driver) o;

        if (driverid != null ? !driverid.equals(driver.driverid) : driver.driverid != null)
            return false;
        if (identity != null ? !identity.equals(driver.identity) : driver.identity != null)
            return false;
        if (account != null ? !account.equals(driver.account) : driver.account != null)
            return false;
        if (pwd != null ? !pwd.equals(driver.pwd) : driver.pwd != null)
            return false;
        if (msid != null ? !msid.equals(driver.msid) : driver.msid != null)
            return false;
        if (kabnum != null ? !kabnum.equals(driver.kabnum) : driver.kabnum != null)
            return false;
        if (name != null ? !name.equals(driver.name) : driver.name != null)
            return false;
        if (sex != null ? !sex.equals(driver.sex) : driver.sex != null)
            return false;
        if (phone != null ? !phone.equals(driver.phone) : driver.phone != null)
            return false;
        if (createtime != null ? !createtime.equals(driver.createtime) : driver.createtime != null)
            return false;
        if (curtime != null ? !curtime.equals(driver.curtime) : driver.curtime != null)
            return false;
        if (lastlg != null ? !lastlg.equals(driver.lastlg) : driver.lastlg != null)
            return false;
        if (lastlt != null ? !lastlt.equals(driver.lastlt) : driver.lastlt != null)
            return false;
        if (gpstime != null ? !gpstime.equals(driver.gpstime) : driver.gpstime != null)
            return false;
        if (isonline != null ? !isonline.equals(driver.isonline) : driver.isonline != null)
            return false;
        if (company != null ? !company.equals(driver.company) : driver.company != null)
            return false;
        if (isstop != null ? !isstop.equals(driver.isstop) : driver.isstop != null)
            return false;
        if (driverPic != null ? !driverPic.equals(driver.driverPic) : driver.driverPic != null)
            return false;
        if (driveridentityPic != null ? !driveridentityPic.equals(driver.driveridentityPic) : driver.driveridentityPic != null)
            return false;
        if (drivingPic != null ? !drivingPic.equals(driver.drivingPic) : driver.drivingPic != null)
            return false;
        if (OperationID != null ? !OperationID.equals(driver.OperationID) : driver.OperationID != null)
            return false;
        if (LicenseID != null ? !LicenseID.equals(driver.LicenseID) : driver.LicenseID != null)
            return false;
        if (starLevel != null ? !starLevel.equals(driver.starLevel) : driver.starLevel != null)
            return false;
        if (driverCardID != null ? !driverCardID.equals(driver.driverCardID) : driver.driverCardID != null)
            return false;
        if (serialNum != null ? !serialNum.equals(driver.serialNum) : driver.serialNum != null)
            return false;
        if (validityDatetime != null ? !validityDatetime.equals(driver.validityDatetime) : driver.validityDatetime != null)
            return false;
        if (clientid != null ? !clientid.equals(driver.clientid) : driver.clientid != null)
            return false;
        return kabnumid != null ? kabnumid.equals(driver.kabnumid) : driver.kabnumid == null;

    }

    @Override
    public int hashCode() {
        int result = driverid != null ? driverid.hashCode() : 0;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        result = 31 * result + (msid != null ? msid.hashCode() : 0);
        result = 31 * result + (kabnum != null ? kabnum.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (curtime != null ? curtime.hashCode() : 0);
        result = 31 * result + (lastlg != null ? lastlg.hashCode() : 0);
        result = 31 * result + (lastlt != null ? lastlt.hashCode() : 0);
        result = 31 * result + (gpstime != null ? gpstime.hashCode() : 0);
        result = 31 * result + (isonline != null ? isonline.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (isstop != null ? isstop.hashCode() : 0);
        result = 31 * result + (driverPic != null ? driverPic.hashCode() : 0);
        result = 31 * result + (driveridentityPic != null ? driveridentityPic.hashCode() : 0);
        result = 31 * result + (drivingPic != null ? drivingPic.hashCode() : 0);
        result = 31 * result + (OperationID != null ? OperationID.hashCode() : 0);
        result = 31 * result + (LicenseID != null ? LicenseID.hashCode() : 0);
        result = 31 * result + (starLevel != null ? starLevel.hashCode() : 0);
        result = 31 * result + (driverCardID != null ? driverCardID.hashCode() : 0);
        result = 31 * result + (serialNum != null ? serialNum.hashCode() : 0);
        result = 31 * result + (validityDatetime != null ? validityDatetime.hashCode() : 0);
        result = 31 * result + (clientid != null ? clientid.hashCode() : 0);
        result = 31 * result + (kabnumid != null ? kabnumid.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "{" + "driverid=" + driverid + ", account='" + account + '\'' + ", pwd='" + pwd + '\'' + ", msid='" + msid + '\'' + ", kabnum='" + kabnum + '\'' + ", name='" + name + '\'' + ", sex=" + sex + ", phone='" + phone + '\'' + ", createtime=" + createtime + ", curtime=" + curtime + ", lastlg=" + lastlg + ", identity=" + identity + ", lastlt=" + lastlt + ", gpstime=" + gpstime + ", isonline=" + isonline + ", company='" + company + '\'' + ", isstop=" + isstop + ", driverPic='" + driverPic + '\'' + ", driveridentityPic='" + driveridentityPic + '\'' + ", drivingPic='" + drivingPic + '\'' + ", OperationID='" + OperationID + '\'' + ", LicenseID='" + LicenseID + '\'' + ", starLevel='" + starLevel + '\'' + ", driverCardID='" + driverCardID + '\'' + ", serialNum='" + serialNum + '\'' + ", validityDatetime=" + validityDatetime + ", clientid=" + clientid + ", kabnumid=" + kabnumid +
                //                ", carinfoHashSet=" + carinfoHashSet +
                '}';
    }


}
