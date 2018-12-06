package com.spring.jersy.hibernate.model.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * TB_CLIENT
 * Created by sky on 15-8-19
 * 客户信息表,客户下面有群组,上面有上级一级的客户(pid)指定
 * 公司或者企业表
 */
@Entity
@Table(name = "tab_client")
public class Client implements Serializable {
    private static final long serialVersionUID = -131312312312321L;

    private Integer clientId;//id,自增
    private String clientName;//客户名称
    private Integer pid;//上一级id
    private Integer cityFlag;//是否是地市分公司
    private String contactperson;//联系人
    private String phone;//联系电话
    private String address;//地址
    private String company;//公司
    private String email;//邮箱
    private String remark;//备注
    private String token;

    //Client 为0 时为最多的父节点，不能删除，不要一定显示
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientid", unique = true, nullable = false, length = 11)
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientid) {
        this.clientId = clientid;
    }

    @Column(name = "clientname", length = 50)
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Column(name = "pid", length = 50)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    @Column(name = "contactperson", length = 50)
    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    @Column(name = "phone", length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "address", length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "company", length = 50)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Column(name = "email", length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "remark", length = 50)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", clientName='" + clientName + '\'' + ", pid=" + pid + ", cityFlag=" + cityFlag + ", contactperson='" + contactperson + '\'' + ", phone='" + phone + '\'' + ", address='" + address + '\'' + ", company='" + company + '\'' + ", email='" + email + '\'' + ", remark='" + remark + '\'' + '}';
    }

    @Column(name = "cityflag", length = 1)
    public Integer getCityFlag() {
        return cityFlag;
    }

    public void setCityFlag(Integer cityFlag) {
        this.cityFlag = cityFlag;
    }


    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
