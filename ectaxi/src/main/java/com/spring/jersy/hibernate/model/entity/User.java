package com.spring.jersy.hibernate.model.entity;

import org.apache.struts2.json.annotations.JSON;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/3/14.
 */
@Entity
@Table(name = "tab_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer accountID;//id，自增
    private Integer onlineStatus;//在线状态
    private Integer cgFlag;//登录用户权限,9:管理员,8:用户,7:其他
    private Integer dependenceId;//表示登录点
    private Date registerTime;//注册时间
    private Date lastLoginTime;//最后登录时间
    private String userName;//用户名称
    private String accountName;//帐号名称
    private String passwd;//登录密码
    private String remark;//备注
    private Integer isModify;//是否修改权限
    private String company;//所在公司
    private int ClientId = 0;//企业id
    private int islock;//是否锁定
    private int roleid;//权限id
    private String rolename;//权限名称
    private Set<Privilege> privilegeSet = new HashSet<Privilege>();   //用户对应权限


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "accountID", unique = true, nullable = false, length = 11)
    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    @Column(name = "onlineStatus", length = 50)
    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Column(name = "cgFlag", length = 50)
    public Integer getCgFlag() {
        return cgFlag;
    }

    public void setCgFlag(Integer cgFlag) {
        this.cgFlag = cgFlag;
    }

    @Column(name = "dependenceId", length = 50)
    public Integer getDependenceId() {
        return dependenceId;
    }

    public void setDependenceId(Integer dependenceId) {
        this.dependenceId = dependenceId;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registerTime", length = 50)
    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    @JSON(format = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastLoginTime", length = 50)
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Column(name = "userName", nullable = false, length = 50)
    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "accountName", length = 50)
    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Column(name = "passwd", length = 50)
    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Column(name = "remark", length = 50)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "isModify", length = 50)
    public Integer getIsModify() {
        return isModify;
    }

    public void setIsModify(Integer isModify) {
        this.isModify = isModify;
    }

    @Column(name = "islock", length = 2)

    public int getIslock() {
        return islock;
    }

    public void setIslock(int islock) {
        this.islock = islock;
    }

    @Column(name = "company", length = 20)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "tab_user_privilege", joinColumns = {@JoinColumn(name = "accountID")}, inverseJoinColumns = {@JoinColumn(name = "id")})
    public Set<Privilege> getPrivilegeSet() {
        return privilegeSet;
    }

    public void setPrivilegeSet(Set<Privilege> privilegeSet) {
        this.privilegeSet = privilegeSet;
    }

    @Column(name = "ClientId", length = 20)
    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    @Column(name = "roleid", length = 20, columnDefinition = "INT default 0")
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Transient
    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    @Override
    public String toString() {
        return "User{" + "accountID=" + accountID + ", onlineStatus=" + onlineStatus + ", cgFlag=" + cgFlag + ", dependenceId=" + dependenceId + ", registerTime=" + registerTime + ", lastLoginTime=" + lastLoginTime + ", userName='" + userName + '\'' + ", accountName='" + accountName + '\'' + ", passwd='" + passwd + '\'' + ", remark='" + remark + '\'' + ", isModify=" + isModify + ", privilegeSet=" + privilegeSet + '}';
    }
}
