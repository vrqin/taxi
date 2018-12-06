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
@Table(name = "tab_client_setting")
public class ClientSetting implements Serializable {
    private static final long serialVersionUID = -131312312312321L;

    private Integer clientId;//id,自增
    private Integer messagenum;//短信数目
    private Integer orderovertime; //电召单超时 (分钟)
    private Integer droporder; //取消单次数
    private Integer waitminute; //当取消单数达到droporder时，将被暂停接单waitminute分钟

    private String smsid;//接单短信接口id
    private String smskey;//短信接口key
    private String smscancelid;//订单取消短信id

    private Integer distance;//派单距离
    private String areaname;//所属区域

    private String sysname;//所属系统
    private String weixinname;//微信公众号名次

    private String token;

    private String serverIp;   //视频监控ip
    private String serverPort; //视频监控端口


    private long maxdrivernum;

    @Column(name = "maxdrivernum")
    public long getMaxdrivernum() {
        return maxdrivernum;
    }

    public void setMaxdrivernum(long maxdrivernum) {
        this.maxdrivernum = maxdrivernum;
    }

    @Id
    @Column(name = "clientid", unique = true, nullable = false, length = 11)
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    @Column(name = "messagenum", length = 11, columnDefinition = "INT default 0")
    public Integer getMessagenum() {
        return messagenum;
    }

    public void setMessagenum(Integer messagenum) {
        this.messagenum = messagenum;
    }

    @Column(name = "orderovertime", length = 11, columnDefinition = "INT default 30")
    public Integer getOrderovertime() {
        return orderovertime;
    }

    public void setOrderovertime(Integer orderovertime) {
        this.orderovertime = orderovertime;
    }

    @Column(name = "droporder", length = 4, columnDefinition = "INT default 3")
    public Integer getDroporder() {
        return droporder;
    }

    public void setDroporder(Integer droporder) {
        this.droporder = droporder;
    }

    @Column(name = "waitminute", length = 4, columnDefinition = "INT default 40")
    public Integer getWaitminute() {
        return waitminute;
    }

    public void setWaitminute(Integer waitminute) {
        this.waitminute = waitminute;
    }

    @Column(name = "smsid", length = 11)
    public String getSmsid() {
        return smsid;
    }

    public void setSmsid(String smsid) {
        this.smsid = smsid;
    }

    @Column(name = "smskey", length = 50)
    public String getSmskey() {
        return smskey;
    }

    public void setSmskey(String smskey) {
        this.smskey = smskey;
    }

    @Column(name = "distance", length = 10, columnDefinition = "INT default 2000")
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Column(name = "serverIp", length = 50)
    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Column(name = "serverPort", length = 10)
    public String getServerPort() {
        return serverPort;
    }

    public void setServerPort(String serverPort) {
        this.serverPort = serverPort;
    }

    @Column(name = "areaname", length = 20)
    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    @Column(name = "sysname", length = 20)
    public String getSysname() {
        return sysname;
    }

    public void setSysname(String sysname) {
        this.sysname = sysname;
    }

    @Column(name = "weixinname", length = 20)
    public String getWeixinname() {
        return weixinname;
    }

    public void setWeixinname(String weixinname) {
        this.weixinname = weixinname;
    }

    @Column(name = "smscancelid", length = 11)
    public String getSmscancelid() {
        return smscancelid;
    }

    public void setSmscancelid(String smscancelid) {
        this.smscancelid = smscancelid;
    }

    @Transient
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "ClientSetting{" + "clientId=" + clientId + ", messagenum=" + messagenum + ", orderovertime=" + orderovertime + ", droporder=" + droporder + ", waitminute=" + waitminute + ", smsid='" + smsid + '\'' + ", smskey='" + smskey + '\'' + ", smscancelid='" + smscancelid + '\'' + ", distance=" + distance + ", areaname='" + areaname + '\'' + ", sysname='" + sysname + '\'' + ", weixinname='" + weixinname + '\'' + ", token='" + token + '\'' + ", serverIp='" + serverIp + '\'' + ", serverPort='" + serverPort + '\'' + ", maxdrivernum=" + maxdrivernum + '}';
    }
}
