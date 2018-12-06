package com.spring.jersy.hibernate.publics.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
public class ClientBean {
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
    private List<ClientBean> children = null;
    private String iconCls;//节点图标
    private String state;

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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCityFlag() {
        return cityFlag;
    }

    public void setCityFlag(Integer cityFlag) {
        this.cityFlag = cityFlag;
    }

    public String getContactperson() {
        return contactperson;
    }

    public void setContactperson(String contactperson) {
        this.contactperson = contactperson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ClientBean> getChildren() {
        return children;
    }

    public void setChildren(List<ClientBean> children) {
        this.children = children;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
