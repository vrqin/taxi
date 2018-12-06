package com.spring.jersy.hibernate.publics.bean;

/**
 * 惩罚记录
 */
public class PunishmentBean {

    private int id;
    private Integer clientid;//所属公司编码
    private Integer cancelnum;//取消次数
    private String kabnum;//车牌号
    private String msid;//
    private String token;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getClientid() {
        return clientid;
    }

    public void setClientid(Integer clientid) {
        this.clientid = clientid;
    }

    public Integer getCancelnum() {
        return cancelnum;
    }

    public void setCancelnum(Integer cancelnum) {
        this.cancelnum = cancelnum;
    }

    public String getKabnum() {
        return kabnum;
    }

    public void setKabnum(String kabnum) {
        this.kabnum = kabnum;
    }

    public String getMsid() {
        return msid;
    }

    public void setMsid(String msid) {
        this.msid = msid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
